package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.LearnController;
import com.dandelion.automationportal.support.TestEntity;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@TestInstance(Lifecycle.PER_METHOD)
public class LearnControllerQuestionsTest extends BaseControllerTest {

    private LearnController learnController;
    private TestEntity testEntity;

    @Autowired
    public LearnControllerQuestionsTest(LearnController learnController, TestEntity testEntity) {
        this.learnController = learnController;
        this.testEntity = testEntity;
    }

    @BeforeEach
    void initService() {
        initEmbeddedService(testEntity, "questions");
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.data.JsonTestDataStorage#getChapterKeys")
    public void learnControllerSelfCheckTest(String automationKey) {
        String path = "/self-check/" + automationKey;
        verifyLearnController(path);
    }

    protected void verifyLearnController(String path) {
        given().log().all().
                standaloneSetup(learnController).
        when().
                get(path).
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
