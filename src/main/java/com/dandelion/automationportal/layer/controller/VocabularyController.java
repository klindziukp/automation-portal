package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.VocabularyJpaService;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VocabularyController {

    private VocabularyJpaService vocabularyJpaService;

    public VocabularyController(VocabularyJpaService vocabularyJpaService) {
        this.vocabularyJpaService = vocabularyJpaService;
    }

    @GetMapping("/vocabulary")
    @ResponseBody
    public ModelAndView vocabulary() {
        ModelAndView modelAndView = new ModelAndView();
        List<VocabularyItem> vocabularyList = vocabularyJpaService.getAllItemsOrderByKeyAsc();
        modelAndView.addObject("vocabularyList", vocabularyList);
        modelAndView.setViewName("vocabulary-list");
        return modelAndView;
    }
}