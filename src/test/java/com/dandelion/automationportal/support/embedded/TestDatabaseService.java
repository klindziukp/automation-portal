package com.dandelion.automationportal.support.embedded;

import com.dandelion.automationportal.support.DatabaseEntity;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.util.JsonUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestDatabaseService {

    private String databaseName;
    private String host;
    private int port;

    public TestDatabaseService(DatabaseEntity databaseEntity) {
        this.host = databaseEntity.getDataBaseHost();
        this.port = databaseEntity.getDataBasePort();
        this.databaseName = databaseEntity.getDataBaseName();
    }

    public TestDatabaseService(String host, int port, String databaseName) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
    }

    public void createDatabase() {
        MongoClient mongoClient = new MongoClient(host, port);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(this.databaseName);

        try {
            Files.list(Paths.get(JsonTestDataStorage.JSON_FOLDER_PATH)).forEach(path -> {
                String fileName = path.getFileName().toString();
                File file = new File(JsonTestDataStorage.JSON_FOLDER_PATH + fileName);
                insertDocuments(mongoDatabase, file);
            });

            mongoClient.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            mongoClient.close();
        }
    }

    public void dropDatabase() {
        MongoClient mongoClient = new MongoClient(this.host, this.port);
        mongoClient.getDatabase(databaseName).drop();
        mongoClient.close();
    }

    private void insertDocuments(MongoDatabase database, File jsonFile) {
        MongoCollection<Document> collection = database.getCollection(jsonFile.getName().replaceAll(".json", ""));
        List<Document> documents = JsonUtil.fromJson(jsonFile);
        for (Document document : documents) {
            collection.insertOne(document);
        }
    }

}
