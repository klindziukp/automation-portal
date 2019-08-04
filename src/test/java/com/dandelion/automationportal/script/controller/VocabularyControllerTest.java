package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.VocabularyController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

public class VocabularyControllerTest extends BaseControllerTest {

    private VocabularyController vocabularyController;

    @Autowired
    public VocabularyControllerTest(VocabularyController vocabularyController) {
        this.vocabularyController = vocabularyController;
    }

    @Test()
    public void automationControllerTest() {
        verifyAutomationController("/vocabulary");
    }

    private void verifyAutomationController(String path) {
        given().log().all().
                standaloneSetup(vocabularyController).
                when().
                get(path).
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
