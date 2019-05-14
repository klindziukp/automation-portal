package com.dandelion.automationportal.support.embedded;

import com.dandelion.automationportal.support.TestPropertyStorage;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.MongoImportExecutable;
import de.flapdoodle.embed.mongo.MongoImportProcess;
import de.flapdoodle.embed.mongo.MongoImportStarter;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongoImportConfig;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongoImportConfigBuilder;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.config.RuntimeConfigBuilder;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.IRuntimeConfig;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

public class EmbeddedMongoService implements EmbeddedService {

    private String collectionName;
    private String jsonName;

    public EmbeddedMongoService(String jsonCollectionName) {
        this.collectionName = jsonCollectionName;
        this.jsonName = jsonCollectionName + ".json";
    }

    public void fillCollection() {
        MongodExecutable mongoExecutable = null;
        try {
            mongoExecutable = getMongoExecutable();
            String jsonFilePath = new File(JsonTestDataStorage.JSON_FOLDER_PATH + jsonName).getAbsolutePath();
            MongoImportExecutable mongoImportExecutable = mongoImportExecutable(jsonFilePath);
            MongoImportProcess mongoImportProcess = mongoImportExecutable.start();
            mongoImportProcess.stop();
            mongoExecutable.stop();
        } catch (IOException ioEx) {
            if (mongoExecutable != null) {
                mongoExecutable.stop();
            }
        }
    }

    public void dropCollection() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", getNet().getPort());
        mongoClient.getDatabase(TestPropertyStorage.DATABASE_NAME).drop();
    }

    private MongoImportExecutable mongoImportExecutable(String jsonFile) throws IOException {
        IMongoImportConfig mongoImportConfig = new MongoImportConfigBuilder().version(Version.Main.PRODUCTION).net(
                getNet()).db(TestPropertyStorage.DATABASE_NAME).collection(this.collectionName).upsert(true)
                .dropCollection(false).jsonArray(true).importFile(jsonFile).build();

        return MongoImportStarter.getDefaultInstance().prepare(mongoImportConfig);
    }

    private MongodExecutable getMongoExecutable() throws IOException {
        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION).net(getNet()).build();
        IRuntimeConfig runtimeConfig = new RuntimeConfigBuilder().defaults(Command.MongoD).build();
        return MongodStarter.getInstance(runtimeConfig).prepare(mongodConfig);
    }

    private Net getNet() {
        try {
            return new Net(TestPropertyStorage.DATABASE_CONNECTION_PORT, Network.localhostIsIPv6());
        } catch (UnknownHostException uhEx) {
            uhEx.printStackTrace();
            throw new RuntimeException(uhEx);
        }
    }
}
