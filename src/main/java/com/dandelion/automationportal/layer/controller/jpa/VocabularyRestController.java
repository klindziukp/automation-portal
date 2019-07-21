package com.dandelion.automationportal.layer.controller.jpa;

import com.dandelion.automationportal.layer.service.VocabularyJpaService;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VocabularyRestController {

    private VocabularyJpaService vocabularyJpaService;

    public VocabularyRestController(VocabularyJpaService vocabularyJpaService) {
        this.vocabularyJpaService = vocabularyJpaService;
    }

    @GetMapping(value = "api/vocabulary", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<VocabularyItem> vocabulary() {
        return vocabularyJpaService.getAllItemsOrderByKeyAsc();
    }
}
