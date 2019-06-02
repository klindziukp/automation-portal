package com.dandelion.automationportal.support.embedded;

import com.dandelion.automationportal.support.DatabaseEntity;
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

public class TestDatabaseService implements MongoDatabaseService {

    private static final String JSON_EXTENSION = ".json";

    private DatabaseEntity databaseEntity;
    private String databaseName;
    private String fullJsonPath;

    public TestDatabaseService(DatabaseEntity databaseEntity) {
        this.databaseEntity = databaseEntity;
        this.databaseName = databaseEntity.getDataBaseName();
        this.fullJsonPath = String.join(File.separator, System.getProperty("user.dir"), "src", "test", "resources", databaseName, "");
    }

    @Override
    public void createDatabase() {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(this.databaseEntity.getDataBaseName());
        try {
            Files.list(Paths.get(fullJsonPath)).forEach(path -> {
                String fileName = path.getFileName().toString();
                File file = new File(fullJsonPath + fileName);
                insertDocuments(mongoDatabase, file);
            });
            mongoClient.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
            mongoClient.close();
        }
    }

    @Override
    public void dropDatabase() {
        MongoClient mongoClient = getMongoClient();
        mongoClient.getDatabase(databaseName).drop();
        mongoClient.close();
    }

    @Override
    public void createCollection(String collectionName) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(this.databaseEntity.getDataBaseName());
        String filePath = String.join(fullJsonPath, collectionName, JSON_EXTENSION);
        insertDocuments(mongoDatabase, new File(filePath));
        mongoClient.close();
    }

    @Override
    public void dropCollection(String collectionName) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(this.databaseEntity.getDataBaseName());
        mongoDatabase.getCollection(collectionName).drop();
        mongoClient.close();
    }

    private MongoClient getMongoClient() {
        return new MongoClient(databaseEntity.getDataBaseHost(), databaseEntity.getDataBasePort());
    }

    private void insertDocuments(MongoDatabase mongoDatabase, File jsonFile) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(
                jsonFile.getName().replaceAll(JSON_EXTENSION, ""));
        List<Document> documents = JsonUtil.fromJson(jsonFile);
        for (Document document : documents) {
            collection.insertOne(document);
        }
    }
}
