package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

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
    public void automationControllerTest(){
        given().
                standaloneSetup(automationController).
        when().
                get("/automation").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
