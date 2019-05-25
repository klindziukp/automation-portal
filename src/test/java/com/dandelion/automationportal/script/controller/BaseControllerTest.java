package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.support.embedded.TestDatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
        "spring.data.mongodb.uri=mongodb://${embedded.container.mongodb.host}:${embedded.container.mongodb.port}/automation",
})
@Testcontainers
@ActiveProfiles("testcontroller")
public class BaseControllerTest {

    private static TestDatabaseService testDatabaseService;
    private static final int MONGO_EXPOSED_PORT = 27017;
    private static GenericContainer mongoGenericContainer = new GenericContainer("mongo:4.0.3")
            .withExposedPorts(MONGO_EXPOSED_PORT);

    private static String databaseHost;
    private static int databasePort;

    @BeforeAll
    public static void setUpContainer(){
        mongoGenericContainer.start();
        System.out.println("Is container running ? : " + mongoGenericContainer.isRunning());
        System.out.println( mongoGenericContainer.getContainerIpAddress());

        databaseHost = mongoGenericContainer.getContainerIpAddress();
        databasePort = mongoGenericContainer.getMappedPort(MONGO_EXPOSED_PORT);

        System.setProperty("embedded.container.mongodb.host", databaseHost);
        System.setProperty("embedded.container.mongodb.port", String.valueOf(databasePort));
    }

    protected static void initDataBase() {
        testDatabaseService = new TestDatabaseService(databaseHost, databasePort, "automation");
        testDatabaseService.dropDatabase();
        testDatabaseService.createDatabase();
    }

    @AfterEach
    protected void tearDown() {
        testDatabaseService.dropDatabase();
    }
}
