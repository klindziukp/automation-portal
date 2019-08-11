package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.service.VocabularyService;
import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.support.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class VocabularyServiceTest extends BaseServiceScript {

    private VocabularyService vocabularyService;

    @Autowired
    public VocabularyServiceTest(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @Test()
    void findSortedVocabularyItemsTest() {

        GIVEN();
        List<VocabularyItem> expected = TestDataStorage.getTestVocabularyItems();

        WHEN();
        List<VocabularyItem> actual = vocabularyService.getAllItemsOrderByKeyAsc();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getUpdatableEntityFields()).isEqualTo(expected);
    }
}