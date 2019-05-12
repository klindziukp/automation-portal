package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.WelcomeController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

public class WelcomeControllerTest {

    @Test()
    public void welcomeControllerTest(){
        given().
                standaloneSetup(new WelcomeController()).
        when().
                get("/").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
