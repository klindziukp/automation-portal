package com.dandelion.automationportal.script.controller.api;

import com.dandelion.automationportal.layer.controller.api.LearnRestController;
import com.dandelion.automationportal.script.controller.BaseControllerScript;
import org.apache.http.HttpStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class LearnRestControllerQuestionsTest extends BaseControllerScript {

    private LearnRestController learnRestController;

    @Autowired
    public LearnRestControllerQuestionsTest(LearnRestController learnRestController) {
        this.learnRestController = learnRestController;
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.data.JsonTestDataStorage#getChapterKeys")
    public void learnControllerSelfCheckTest(String automationKey) {
        String path = "api/self-check/" + automationKey;
        verifyLearnRestController(path);
    }

    protected void verifyLearnRestController(String path) {
        given().log().all().
                standaloneSetup(learnRestController).
        when().
                get(path).
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
