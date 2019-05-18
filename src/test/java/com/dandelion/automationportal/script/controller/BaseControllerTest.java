package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.support.TestEntity;
import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("testcontroller")
@SpringBootTest
@TestPropertySource("classpath:application-testcontroller.properties")
@TestInstance(Lifecycle.PER_CLASS)
public class BaseControllerTest {

    private static EmbeddedService embeddedService;

    void initEmbeddedService(TestEntity testEntity, String jsonCollectionName) {
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
