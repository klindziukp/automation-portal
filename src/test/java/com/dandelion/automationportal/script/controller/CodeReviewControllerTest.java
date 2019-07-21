package com.dandelion.automationportal.script.controller;

import com.dandelion.automationportal.layer.controller.CodeReviewController;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import java.util.stream.Stream;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class CodeReviewControllerTest extends BaseControllerScript {

    private CodeReviewController codeReviewController;

    @Autowired
    public CodeReviewControllerTest(CodeReviewController codeReviewController) {
        this.codeReviewController = codeReviewController;
    }

    @Test
    public void codeReviewControllerTest() {
        String path = "/code-review";
        verifyLearnController(path);
    }

    @ParameterizedTest
    @MethodSource("getCodeReviewItems")
    public void codeReviewControllerItemsTest(String codeReviewItemName) {
        String path = "/code-review/" + codeReviewItemName;
        verifyLearnController(path);
    }

    private void verifyLearnController(String path) {
        given().log().all().
                standaloneSetup(codeReviewController).
                when().
                get(path).
                then().
                statusCode(HttpStatus.SC_OK);
    }

    private static Stream<String> getCodeReviewItems() {
        return JsonTestDataStorage.getTopicsKeys("code-review").stream();
    }
}
