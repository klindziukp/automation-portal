package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.support.embedded.EmbeddedMongoService;
import com.dandelion.automationportal.support.embedded.EmbeddedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("test")
public class BaseMongoRepositoryTest {

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
