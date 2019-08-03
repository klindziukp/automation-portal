package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

public class AutomationControllerTest extends BaseControllerTest {

    private AutomationController automationController;

    @Autowired
    public AutomationControllerTest(AutomationController automationController) {
        this.automationController = automationController;
    }

    @Test()
    public void automationControllerTest() {
        verifyAutomationController("/automation");
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
