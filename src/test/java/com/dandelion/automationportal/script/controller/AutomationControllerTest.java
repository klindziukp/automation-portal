package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import com.dandelion.automationportal.support.TestEntity;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
public class AutomationControllerTest extends BaseControllerTest {

    private AutomationController automationController;
    private TestEntity testEntity;

    @Autowired
    public AutomationControllerTest(AutomationController automationController, TestEntity testEntity) {
        this.automationController = automationController;
        this.testEntity = testEntity;
    }

    @BeforeAll
    void initEmbeddedService() {
        initEmbeddedService(testEntity, "program");
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
