package com.dandelion.automationportal.script.controller.api;

import com.dandelion.automationportal.layer.controller.api.AutomationRestController;
import com.dandelion.automationportal.script.controller.BaseControllerScript;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class AutomationRestControllerTest extends BaseControllerScript {

    private static final String PATH = "api/automation/";

    private AutomationRestController automationRestController;

    @Autowired
    public AutomationRestControllerTest(AutomationRestController automationRestController ) {
        this.automationRestController = automationRestController;
    }

    @Test()
    public void automationControllerTest() {
        verifyAutomationRestController(PATH);
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.ProgramType#getProgramKeys")
    public void automationControllersTest(String automationKey) {
        String path = PATH + automationKey;
        verifyAutomationRestController(path);
    }

    private void verifyAutomationRestController(String path) {
        given().log().all().
                standaloneSetup(automationRestController).
        when().
                get(path).
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
