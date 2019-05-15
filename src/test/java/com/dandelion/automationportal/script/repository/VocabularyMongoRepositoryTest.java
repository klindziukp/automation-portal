package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.layer.repository.mongo.VocabularyMongoRepository;
import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.data.TestDataStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class VocabularyMongoRepositoryTest extends BaseMongoRepositoryTest {

    private VocabularyMongoRepository vocabularyMongoRepository;

    @Autowired
    public VocabularyMongoRepositoryTest(VocabularyMongoRepository vocabularyMongoRepository) {
        this.vocabularyMongoRepository = vocabularyMongoRepository;
    }

    @BeforeAll
    static void initEmbeddedService(){
        initEmbeddedService("vocabulary");
    }

    @Test()
    void findSortedVocabularyItemsTest() {

        GIVEN();
        List<VocabularyItem> expected = JsonTestDataStorage.getVocabularyItems()
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        WHEN();
        List<VocabularyItem> actual = vocabularyMongoRepository.findAllByOrderByKeyAsc();

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test()
    void findAllVocabularyItemTest() {

        GIVEN();
        List<VocabularyItem> expectedItems = JsonTestDataStorage.getVocabularyItems();

        WHEN();
        List<VocabularyItem> actualItems = vocabularyMongoRepository.findAll();

        THEN();
        assertThat(expectedItems).usingElementComparatorIgnoringFields("id").isEqualTo(actualItems);
    }

    @Test()
    void insertVocabularyItemTest() {

        GIVEN();
        VocabularyItem testVocabularyItem = TestDataStorage.getTestVocabularyItem();

        WHEN();
        vocabularyMongoRepository.insert(testVocabularyItem);
        List<VocabularyItem> vocabularyItems = vocabularyMongoRepository.findAll();

        THEN();
        assertThat(vocabularyItems).contains(testVocabularyItem);
    }

    @Test()
    void deleteVocabularyItemTest() {

        GIVEN();
        VocabularyItem itemToDelete = vocabularyMongoRepository.findAll().get(0);
        List<VocabularyItem> listBeforeDelete = vocabularyMongoRepository.findAll();
        assertThat(listBeforeDelete).contains(itemToDelete);

        WHEN();
        vocabularyMongoRepository.delete(itemToDelete);
        List<VocabularyItem> listAfterDelete = vocabularyMongoRepository.findAll();

        THEN();
        assertThat(listAfterDelete).isNotEqualTo(listBeforeDelete);
        assertThat(listAfterDelete).doesNotContain(itemToDelete);
    }
}
