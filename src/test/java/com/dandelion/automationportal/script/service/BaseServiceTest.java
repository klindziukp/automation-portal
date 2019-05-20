package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.support.TestEntity;
import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("testservice")
@ComponentScan("com.dandelion.automationportal")
public class BaseServiceTest {

    private static EmbeddedService embeddedService;

    static void initEmbeddedService(TestEntity testEntity, String jsonCollectionName) {
        embeddedService = new EmbeddedMongoService(jsonCollectionName, testEntity);
        embeddedService.fillCollection();
    }

    @AfterEach
    protected void tearDown() {
        embeddedService.dropCollection();
    }
}
