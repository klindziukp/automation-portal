package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.WelcomeController;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class WelcomeControllerTest extends BaseControllerTest {

    private WelcomeController welcomeController;

    @Autowired
    public WelcomeControllerTest(WelcomeController welcomeController) {
        this.welcomeController = welcomeController;
    }

    @Test()
    public void welcomeControllerTest(){
        given().log().all().
                standaloneSetup(welcomeController).
        when().
                get("/").
        then().
                statusCode(HttpStatus.SC_OK);
    }
}
