package com.dandelion.automationportal.script.controller.rest;

import com.dandelion.automationportal.layer.controller.rest.VocabularyRestController;
import com.dandelion.automationportal.script.controller.BaseControllerScript;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@Profile("test-integration")
public class VocabularyRestControllerTest extends BaseControllerScript {

    private VocabularyRestController vocabularyRestController;

    private static final String PATH = "api/vocabulary";

    @Autowired
    public VocabularyRestControllerTest(VocabularyRestController vocabularyRestController) {
        this.vocabularyRestController = vocabularyRestController;
    }

    @Test()
    public void automationControllerTest() {
        verifyRestAutomationController(PATH);
    }

    private void verifyRestAutomationController(String path) {
       given().log().all().
                standaloneSetup(vocabularyRestController).
                when().
                get(path).
                then().
                statusCode(HttpStatus.SC_OK);
   }
}
