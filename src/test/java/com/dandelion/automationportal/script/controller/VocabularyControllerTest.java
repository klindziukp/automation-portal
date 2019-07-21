package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.VocabularyController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class VocabularyControllerTest extends BaseControllerScript {

    private VocabularyController vocabularyController;

    @Autowired
    public VocabularyControllerTest(VocabularyController vocabularyController) {
        this.vocabularyController = vocabularyController;
    }

    @Test
    public void vocabularyControllerTest(){
        given().log().all().
                standaloneSetup(vocabularyController).
        when().
                get("/vocabulary").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
