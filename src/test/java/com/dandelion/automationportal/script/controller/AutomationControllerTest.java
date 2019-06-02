package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class AutomationControllerTest extends BaseControllerScript {

    private AutomationController automationController;

    @Autowired
    public AutomationControllerTest(AutomationController automationController ) {
        this.automationController = automationController;
    }

    @BeforeEach
    public void initDatabase() {
        initDataBase();
    }

    @Test()
    public void automationControllerTest() {
        verifyAutomationController("/automation");
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.ProgramType#getProgramKeys")
    public void automationControllersTest(String automationKey) {
        String path = "/automation/" + automationKey;
        verifyAutomationController(path);
    }

    private void verifyAutomationController(String path) {
        given().log().all().
                standaloneSetup(automationController).
        when().
                get(path).
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
