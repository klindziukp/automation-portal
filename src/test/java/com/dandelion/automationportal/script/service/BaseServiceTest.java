package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.support.TestEntity;
import com.dandelion.automationportal.support.TestPropertyService;
import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("test")
public class BaseServiceTest {

    private static EmbeddedService embeddedService;

    static void initEmbeddedService(String jsonCollectionName) {
        TestPropertyService testPropertyService = new TestPropertyService("application-test");
        TestEntity testEntity = new TestEntity(testPropertyService);
        embeddedService = new EmbeddedMongoService(jsonCollectionName, testEntity);
    }

    @BeforeEach
   protected void setUp() {
        embeddedService.fillCollection();
    }

    @AfterEach
   protected void tearDown() {
        embeddedService.dropCollection();
    }
}
