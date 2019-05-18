package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import com.dandelion.automationportal.support.AutomationType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    static void initEmbeddedService() {
        initEmbeddedService("program");
    }

    @Test()
    public void automationControllerTest() {
        verifyAutomationController("/automation");
    }

    @Test()
    public void automationControllersTest() {
        for (String automationKey : AutomationType.getAutomationKeys()) {
            String path = "/automation/" + automationKey;
            verifyAutomationController(path);
        }
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
