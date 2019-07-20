package com.dandelion.automationportal.layer.controller.api;

import com.dandelion.automationportal.layer.service.VocabularyService;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VocabularyRestController {

    private VocabularyService vocabularyService;

    @Autowired
    public VocabularyRestController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping(value = "api/vocabulary", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<VocabularyItem> vocabulary() {
        return vocabularyService.getAllItemsOrderByKeyAsc();
    }
}
