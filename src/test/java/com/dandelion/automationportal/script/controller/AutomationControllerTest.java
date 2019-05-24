package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import com.dandelion.automationportal.support.DatabaseEntity;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
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
    private DatabaseEntity databaseEntity;

    @Autowired
    public AutomationControllerTest(AutomationController automationController, DatabaseEntity databaseEntity) {
        this.automationController = automationController;
        this.databaseEntity = databaseEntity;
    }

    @BeforeClass
    public static void initEmbeddedService() {
        initDataBase();
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
