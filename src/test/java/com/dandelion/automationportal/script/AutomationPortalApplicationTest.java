package com.dandelion.automationportal.script;

import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.embedded.TestDatabaseService;
import com.dandelion.automationportal.support.util.JsonUtil;
import com.jupiter.tools.spring.test.mongo.annotation.MongoDataSet;
import com.jupiter.tools.spring.test.mongo.junit5.meta.annotation.MongoDbIntegrationTest;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ActiveProfiles("testcontroller")
public class AutomationPortalApplicationTest extends AbstractIntegrationTest {

    static GenericContainer mongo;

    static {
        mongo = new GenericContainer("mongo:4.0.3")
                .withExposedPorts(27017);
        mongo.start();
        System.out.println("Is container running ? : " + mongo.isRunning());
        System.out.println( mongo.getContainerIpAddress());

        String port = String.valueOf(mongo.getMappedPort(27017));
        System.out.println(port);
        System.setProperty("embedded.container.mongodb.host", mongo.getContainerIpAddress());
        System.setProperty("embedded.container.mongodb.port", port);

    }

    @Test
    public void simpleMongoDbTest() {
        TestDatabaseService testDatabaseService;
        testDatabaseService = new TestDatabaseService(mongo.getContainerIpAddress() ,mongo.getMappedPort(27017 ),"automation" );
        testDatabaseService.createDatabase();
    }

    @AfterClass
    public static void tearDown(){
        mongo.stop();
        System.out.println("Is container running ? : " + mongo.isRunning());
    }

}
