package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.layer.repository.mongo.CodeReviewMongoRepository;
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
class CodeReviewMongoRepositoryTest extends BaseMongoRepositoryScript {

    private CodeReviewMongoRepository codeReviewMongoRepository;
    private DatabaseEntity databaseEntity;

    @Autowired
    public CodeReviewMongoRepositoryTest(CodeReviewMongoRepository CodeReviewMongoRepository, DatabaseEntity databaseEntity) {
        this.codeReviewMongoRepository = CodeReviewMongoRepository;
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
        List<CodeReviewItem> actual = codeReviewMongoRepository.findAll();

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test()
    void findAllTopicsByKeyTest() {

        GIVEN();
        List<CodeReviewItem> allTopics = JsonTestDataStorage.getCodeReviewItems();
        String expectedKey = JsonTestDataStorage.getCodeReviewItems().get(0).getTopicKey();
        List<CodeReviewItem> expected = allTopics.stream().filter(topic -> topic.getTopicKey().equals(expectedKey)).collect(Collectors.toList());

        WHEN();
        List<CodeReviewItem> actual = codeReviewMongoRepository.findAllByTopicKey(expectedKey);

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test
    void insertChapterTest() {

        GIVEN();
        CodeReviewItem testCodeReviewItem = TestDataStorage.getTestCodeReviewItem();

        WHEN();
        codeReviewMongoRepository.insert(testCodeReviewItem);
        List<CodeReviewItem> after = codeReviewMongoRepository.findAll();

        THEN();
        assertThat(after).contains(testCodeReviewItem);
    }

    @Test
    void deleteChapterTest() {

        GIVEN();
        CodeReviewItem testCodeReviewItem = codeReviewMongoRepository.findAll().get(0);
        List<CodeReviewItem> listBeforeDelete = codeReviewMongoRepository.findAll();

        WHEN();
        codeReviewMongoRepository.delete(testCodeReviewItem);
        List<CodeReviewItem> listAfterDelete = codeReviewMongoRepository.findAll();

        THEN();
        assertThat(listAfterDelete).isNotEqualTo(listBeforeDelete);
        assertThat(listAfterDelete).doesNotContain(testCodeReviewItem);
    }

    @Test
    void deleteAllTopicsTest() {

        GIVEN();
        codeReviewMongoRepository.deleteAll();

        WHEN();
        int chapterQuantity = codeReviewMongoRepository.findAll().size();

        THEN();
        assertThat(chapterQuantity).isEqualTo(0);
    }
}
