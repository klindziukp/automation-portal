package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.LearnController;
import com.dandelion.automationportal.support.TestEntity;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
public class LearnControllerTest extends BaseControllerTest {

    private LearnController learnController;
    private TestEntity testEntity;

    @Autowired
    public LearnControllerTest(LearnController learnController, TestEntity testEntity) {
        this.learnController = learnController;
        this.testEntity = testEntity;
    }

    @BeforeAll
    void initService() {
        initEmbeddedService(testEntity, "chapters");
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.data.JsonTestDataStorage#getChapterKeys")
    public void learnControllerChapterTest(String automationKey) {
            String path = "/chapter/" + automationKey;
            verifyLearnController(path);
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.data.JsonTestDataStorage#getChapterKeys")
    public void learnControllerSelfCheckTest(String automationKey) {
        String path = "/self-check/" + automationKey;
        verifyLearnController(path);
    }

    private void verifyLearnController(String path) {
        given().log().all().
                standaloneSetup(learnController).
        when().
                get(path).
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
