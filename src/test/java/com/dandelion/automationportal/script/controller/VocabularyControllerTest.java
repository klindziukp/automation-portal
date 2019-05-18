package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.VocabularyController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
public class VocabularyControllerTest extends BaseControllerTest {

    private VocabularyController vocabularyController;

    @Autowired
    public VocabularyControllerTest(VocabularyController vocabularyController) {
        this.vocabularyController = vocabularyController;
    }

    @BeforeAll
    static void initEmbeddedService() {
        initEmbeddedService("vocabulary");
    }

    @Test()
    public void vocabularyControllerTest(){
        given().
                standaloneSetup(vocabularyController).
        when().
                get("/vocabulary").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
