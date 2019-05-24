package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.LearnController;
import com.dandelion.automationportal.support.DatabaseEntity;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
@TestInstance(Lifecycle.PER_METHOD)
public class LearnControllerChaptersTest extends BaseControllerTest {

    private LearnController learnController;
    private DatabaseEntity databaseEntity;

    @Autowired
    public LearnControllerChaptersTest(LearnController learnController, DatabaseEntity databaseEntity) {
        this.learnController = learnController;
        this.databaseEntity = databaseEntity;
    }

    @BeforeEach
    static void initService() {
        initDataBase();
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.data.JsonTestDataStorage#getChapterKeys")
    public void learnControllerChaptersTest(String automationKey) {
            String path = "/chapter/" + automationKey;
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
