package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.support.DatabaseEntity;
import com.dandelion.automationportal.support.embedded.TestDatabaseService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
        "spring.data.mongodb.uri=mongodb://${embedded.container.mongodb.host}:${embedded.container.mongodb.port}/automation",
})
@Testcontainers
@ActiveProfiles("test-integration")
@Execution(ExecutionMode.CONCURRENT)
public class BaseControllerScript {

    private static final int MONGO_EXPOSED_PORT = 27017;
    private static GenericContainer mongoGenericContainer = new GenericContainer("mongo:4.0.3").withExposedPorts(MONGO_EXPOSED_PORT);

    private static TestDatabaseService testDatabaseService;
    private static DatabaseEntity databaseEntity;

    @BeforeAll
    public static void setUpContainer(){
        mongoGenericContainer.start();
        databaseEntity = initDataBaseEntity(mongoGenericContainer);
        System.setProperty("embedded.container.mongodb.host", databaseEntity.getDataBaseHost());
        System.setProperty("embedded.container.mongodb.port", String.valueOf(databaseEntity.getDataBasePort()));

        initDataBase();
    }

    @AfterAll
    protected static void tearDown() {
        testDatabaseService.dropDatabase();
    }

    private static void initDataBase() {
        testDatabaseService = new TestDatabaseService(databaseEntity);
        testDatabaseService.dropDatabase();
        testDatabaseService.createDatabase();
    }

    private static DatabaseEntity initDataBaseEntity(GenericContainer genericContainer) {
        DatabaseEntity databaseEntity = new DatabaseEntity();
        databaseEntity.setDataBaseHost(genericContainer.getContainerIpAddress());
        databaseEntity.setDataBasePort(genericContainer.getMappedPort(MONGO_EXPOSED_PORT));
        databaseEntity.setDataBaseName("automation");
        return databaseEntity;
    }
}
