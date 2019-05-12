package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseControllerTest {
    private static EmbeddedService embeddedService;

    static void initEmbeddedService(String jsonCollectionName){
        embeddedService = new EmbeddedMongoService(jsonCollectionName);
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
