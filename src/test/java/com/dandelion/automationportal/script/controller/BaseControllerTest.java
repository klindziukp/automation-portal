package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.support.TestEntity;
import com.dandelion.automationportal.support.TestPropertyService;
import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("testcontroller")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseControllerTest {

    @Value("${server.port}")
    private int port;

    @Value("${server.host}")
    private String host;

    private static EmbeddedService embeddedService;

    static void initEmbeddedService(String jsonCollectionName) {
        TestPropertyService testPropertyService = new TestPropertyService("application-testcontroller");
        TestEntity testEntity = new TestEntity(testPropertyService);
        embeddedService = new EmbeddedMongoService(jsonCollectionName, testEntity);
    }

    @BeforeEach
    protected void setUp() {
        setBaseUriAndPort();
        embeddedService.fillCollection();
    }

    @AfterEach
    protected void tearDown() {
        embeddedService.dropCollection();
    }

    private void setBaseUriAndPort(){
        RestAssured.port = port;
        RestAssured.baseURI = host;
    }
}
