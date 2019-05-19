package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.support.TestEntity;
import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("test")
@ContextConfiguration(classes = TestEntity.class)
@TestPropertySource("classpath:application-test.properties")
@ComponentScan("com.dandelion.automationportal")
public class BaseMongoRepositoryTest {

    private EmbeddedService embeddedService;

    void initEmbeddedService(String jsonCollectionName, TestEntity testEntity) {
        embeddedService = new EmbeddedMongoService(jsonCollectionName, testEntity);
        embeddedService.fillCollection();
    }

    @AfterEach
    protected void tearDown() {
        embeddedService.dropCollection();
    }
}
