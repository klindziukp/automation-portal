package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.LearnController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class LearnControllerQuestionsTest extends BaseControllerTest {

    private LearnController learnController;

    @Autowired
    public LearnControllerQuestionsTest(LearnController learnController) {
        this.learnController = learnController;
    }

    @BeforeEach
    public void initService() {
        initDataBase();
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
