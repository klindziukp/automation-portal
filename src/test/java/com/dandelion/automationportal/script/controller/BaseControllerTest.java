package com.dandelion.automationportal.script.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ExtendWith(SpringExtension.class)
@Profile("test-integration")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(initializers = { BaseControllerTest.Initializer.class })
public class BaseControllerTest {

    private static final int MYSQL_EXPOSED_PORT = 3306;

    private static MySQLContainer mySqlContainer = (MySQLContainer) new MySQLContainer("mysql:5.7.24")
            .withDatabaseName("automation")
            .withExposedPorts(MYSQL_EXPOSED_PORT);

    @BeforeAll
    protected static void setUp() {
        mySqlContainer.start();
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of("spring.datasource.url=" + mySqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + mySqlContainer.getUsername(),
                    "spring.datasource.password=" + mySqlContainer.getPassword()).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}

