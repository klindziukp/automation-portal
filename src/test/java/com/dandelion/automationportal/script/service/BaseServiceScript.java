package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.support.DatabaseEntity;
import com.dandelion.automationportal.support.embedded.TestDatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("test-service")
@TestPropertySource("classpath:application-test-service.properties")
@ComponentScan("com.dandelion.automationportal")
public class BaseServiceScript {

    private TestDatabaseService testDatabaseService;

    void initDatabase(DatabaseEntity databaseEntity) {
        testDatabaseService = new TestDatabaseService(databaseEntity);
        testDatabaseService.dropDatabase();
        testDatabaseService.createDatabase();
    }

    @AfterEach
    protected void tearDown() {
        testDatabaseService.dropDatabase();
    }
}
