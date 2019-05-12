package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.AutomationController;
import com.dandelion.automationportal.layer.service.ProgramService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = AutomationController.class, secure = false)
@AutoConfigureDataMongo
@ActiveProfiles("testcontroller")
@ComponentScan("com.dandelion.automationportal")
public class AutomationControllerTest extends BaseControllerTest {

    private ProgramService programService;

    @Autowired
    public AutomationControllerTest(ProgramService programService) {
        this.programService = programService;
    }

    @BeforeAll
    static void initEmbeddedService() {
        initEmbeddedService("program");
    }

    @Test()
    public void automationTest() {
        given().
                standaloneSetup(new AutomationController(programService)).
                when().
                get("/automation").
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
