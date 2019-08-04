package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.repository.VocabularyRepository;
import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.support.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class VocabularyJpaRepositoryTest extends BaseRepositoryTest {

    private VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabularyJpaRepositoryTest(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    @Test()
    void findSortedVocabularyItemsTest() {

        GIVEN();
        List<VocabularyItem> expected = TestDataStorage.getTestVocabularyItems();

        WHEN();
        List<VocabularyItem> actual = vocabularyRepository.findAllByOrderByKeyAsc();
        System.out.println(actual.get(0).toString());

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getUpdatableEntityFields()).isEqualTo(expected);
    }
}