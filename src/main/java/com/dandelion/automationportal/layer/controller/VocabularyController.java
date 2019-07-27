package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.VocabularyService;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VocabularyController {

    private VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping("/vocabulary")
    @ResponseBody
    public ModelAndView vocabulary() {
        ModelAndView modelAndView = new ModelAndView();
        List<VocabularyItem> vocabularyList = vocabularyService.getAllItemsOrderByKeyAsc();
        modelAndView.addObject("vocabularyList", vocabularyList);
        modelAndView.setViewName("vocabulary-list");
        return modelAndView;
    }
}