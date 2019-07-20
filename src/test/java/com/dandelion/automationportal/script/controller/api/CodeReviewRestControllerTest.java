package com.dandelion.automationportal.script.controller.api;

import com.dandelion.automationportal.layer.controller.api.CodeReviewRestController;
import com.dandelion.automationportal.script.controller.BaseControllerScript;
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
public class CodeReviewRestControllerTest extends BaseControllerScript {

    private static final String PATH = "api/code-review/";

    private CodeReviewRestController codeReviewRestController;

    @Autowired
    public CodeReviewRestControllerTest(CodeReviewRestController codeReviewRestController) {
        this.codeReviewRestController = codeReviewRestController;
    }

    @Test
    public void codeReviewControllerTest() {
        verifyLearnRestController(PATH);
    }

    @ParameterizedTest
    @MethodSource("getCodeReviewItems")
    public void codeReviewControllerItemsTest(String codeReviewItemName) {
        String path = PATH + codeReviewItemName;
        verifyLearnRestController(path);
    }

    private void verifyLearnRestController(String path) {
        given().log().all().
                standaloneSetup(codeReviewRestController).
                when().
                get(path).
                then().
                statusCode(HttpStatus.SC_OK);
    }

    private static Stream<String> getCodeReviewItems() {
        return JsonTestDataStorage.getTopicsKeys("code-review").stream();
    }
}
