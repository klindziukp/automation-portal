package com.dandelion.automationportal.script.controller.rest;

import com.dandelion.automationportal.layer.controller.rest.AutomationRestController;
import com.dandelion.automationportal.model.AutomationType;
import com.dandelion.automationportal.script.controller.BaseControllerTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@Profile("test-integration")
public class AutomationRestControllerTest extends BaseControllerTest {

    private AutomationRestController automationRestController;

    private static final String PATH = "api/automation";

    @Autowired
    public AutomationRestControllerTest(AutomationRestController automationRestController) {
        this.automationRestController = automationRestController;
    }

    @Test()
    public void automationControllerTest() {
        verifyRestAutomationController(PATH);
    }

    private void verifyRestAutomationController(String path) {
        final String s = given().log().all().
                standaloneSetup(automationRestController).
                when().
                get(path).
                then().
                statusCode(HttpStatus.SC_OK).extract().body().toString();
        System.out.println(s);
    }
}
