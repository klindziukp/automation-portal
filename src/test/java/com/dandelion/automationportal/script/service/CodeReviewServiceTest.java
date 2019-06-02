package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.layer.service.CodeReviewService;
import com.dandelion.automationportal.model.CodeReviewItem;
import com.dandelion.automationportal.support.DatabaseEntity;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.data.TestDataStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_METHOD)
class CodeReviewServiceTest extends BaseServiceTest {

    private CodeReviewService codeReviewService;
    private DatabaseEntity databaseEntity;

    @Autowired
    public CodeReviewServiceTest(CodeReviewService codeReviewService, DatabaseEntity databaseEntity) {
        this.codeReviewService = codeReviewService;
        this.databaseEntity = databaseEntity;
    }

    @BeforeEach
    void initDatabase() {
        initDatabase(databaseEntity);
    }

    @Test()
    void findAllCodeReviewItemsTest() {

        GIVEN();
        List<CodeReviewItem> expected = JsonTestDataStorage.getCodeReviewItems();

        WHEN();
        List<CodeReviewItem> actual = codeReviewService.getAllCodeReviewItems();

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test()
    void findAllCodeReviewItemsByKeyTest() {

        GIVEN();
        List<CodeReviewItem> allTopics = JsonTestDataStorage.getCodeReviewItems();
        String expectedKey = JsonTestDataStorage.getCodeReviewItems().get(0).getTopicKey();
        List<CodeReviewItem> expected = allTopics.stream().filter(topic -> topic.getTopicKey().equals(expectedKey)).collect(Collectors.toList());

        WHEN();
        List<CodeReviewItem> actual = codeReviewService.getCodeReviewItemsByTopicKey(expectedKey);

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }
}
