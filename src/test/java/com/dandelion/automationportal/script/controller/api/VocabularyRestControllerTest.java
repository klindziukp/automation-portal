package com.dandelion.automationportal.script.controller.api;

import com.dandelion.automationportal.layer.controller.api.VocabularyRestController;
import com.dandelion.automationportal.script.controller.BaseControllerScript;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class VocabularyRestControllerTest extends BaseControllerScript {

    private VocabularyRestController vocabularyRestController;

    @Autowired
    public VocabularyRestControllerTest(VocabularyRestController vocabularyRestController) {
        this.vocabularyRestController = vocabularyRestController;
    }

    @Test
    public void vocabularyControllerTest(){
        given().log().all().
                standaloneSetup(vocabularyRestController).
        when().
                get("api/vocabulary").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
