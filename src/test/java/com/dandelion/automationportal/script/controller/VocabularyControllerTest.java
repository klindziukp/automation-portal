package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.VocabularyController;
import com.dandelion.automationportal.support.TestEntity;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
@TestInstance(Lifecycle.PER_METHOD)
public class VocabularyControllerTest extends BaseControllerTest {

    private VocabularyController vocabularyController;
    private TestEntity testEntity;

    @Autowired
    public VocabularyControllerTest(VocabularyController vocabularyController, TestEntity testEntity) {
        this.vocabularyController = vocabularyController;
        this.testEntity = testEntity;
    }

    @BeforeEach
    void initEmbeddedService() {
        initEmbeddedService(testEntity, "vocabulary");
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
