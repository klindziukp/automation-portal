package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
public class AutomationControllerTest extends BaseControllerTest {

    private AutomationController automationController;

    @Autowired
    public AutomationControllerTest(AutomationController automationController) {
        this.automationController = automationController;
    }

    @BeforeAll
    static void initService() {
        initEmbeddedService("program");
    }

    @Test()
    public void automationControllerTest() {
        verifyAutomationController("/automation");
    }

    @ParameterizedTest
    @MethodSource("com.dandelion.automationportal.support.AutomationType#getAutomationKeys")
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
