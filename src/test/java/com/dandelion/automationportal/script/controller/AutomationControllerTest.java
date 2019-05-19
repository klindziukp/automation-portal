package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import com.dandelion.automationportal.support.TestEntity;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration
@TestInstance(Lifecycle.PER_METHOD)
public class AutomationControllerTest extends BaseControllerTest {

    private AutomationController automationController;
    private TestEntity testEntity;

    @Autowired
    public AutomationControllerTest(AutomationController automationController, TestEntity testEntity) {
        this.automationController = automationController;
        this.testEntity = testEntity;
    }

    @BeforeEach
    void initEmbeddedService() {
        initEmbeddedService(testEntity, "program");
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
