package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.support.embedded.TestDatabaseService;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
        "spring.data.mongodb.uri=mongodb://${embedded.container.mongodb.host}:${embedded.container.mongodb.port}/automation"
})
@RunWith(SpringRunner.class)
@ActiveProfiles("testcontroller")
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongoGenericCintainer.embedded.EmbeddedMongoAutoConfiguration")
public class BaseControllerTest {

    static TestDatabaseService testDatabaseService;
    static GenericContainer mongoGenericCintainer;

    static {
        mongoGenericCintainer = new GenericContainer("mongo:4.0.3")
                .withExposedPorts(27017);
        mongoGenericCintainer.start();
        System.out.println("Is container running ? : " + mongoGenericCintainer.isRunning());
        System.out.println( mongoGenericCintainer.getContainerIpAddress());

        String port = String.valueOf(mongoGenericCintainer.getMappedPort(27017));
        System.out.println(port);
        System.setProperty("embedded.container.mongodb.host", mongoGenericCintainer.getContainerIpAddress());
        System.setProperty("embedded.container.mongodb.port", port);

    }

    public static void initDataBase() {
        testDatabaseService = new TestDatabaseService(mongoGenericCintainer.getContainerIpAddress(),
                mongoGenericCintainer.getMappedPort(27017), "automation");
        testDatabaseService.createDatabase();
    }

    @AfterClass
    public static void tearDown(){
        mongoGenericCintainer.stop();
        System.out.println("Is container running ? : " + mongoGenericCintainer.isRunning());

    }
}
