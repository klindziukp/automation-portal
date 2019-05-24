package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.VocabularyController;
import com.dandelion.automationportal.support.DatabaseEntity;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration")
public class VocabularyControllerTest extends BaseControllerTest {

    @Autowired
    private VocabularyController vocabularyController;

    public VocabularyControllerTest() {}

    @BeforeClass
    public static void initEmbeddedService() {
        initDataBase();
    }

    @Test
    public void vocabularyControllerTest(){
        given().
                standaloneSetup(vocabularyController).
        when().
                get("/vocabulary").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
