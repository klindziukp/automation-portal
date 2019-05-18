package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.layer.service.VocabularyService;
import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class VocabularyServiceTest extends BaseServiceTest {

    private VocabularyService vocabularyService;

    @Autowired
    public VocabularyServiceTest(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @BeforeAll
    static void initEmbeddedService() {
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
        List<VocabularyItem> actual = vocabularyService.getAllItemsOrderByKeyAsc();

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }
}