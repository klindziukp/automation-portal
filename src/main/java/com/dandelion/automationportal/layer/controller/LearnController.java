package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.LearnService;
import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LearnController {

    private LearnService learnService;

    @Autowired
    public LearnController(LearnService learnService) {
        this.learnService = learnService;
    }

    @GetMapping("/self-check/{chapterKey}")
    public ModelAndView selfCheck(@PathVariable("chapterKey") String chapterKey) {
        ModelAndView modelAndView = new ModelAndView();
        List<SelfCheckQuestion> questions = learnService.findAllByChapterKey(chapterKey);
        modelAndView.addObject("selfCheckQuestions", questions);
        modelAndView.addObject("chapterName", learnService.getChapterNameFromKey(chapterKey));
        modelAndView.setViewName("self-check");
        return modelAndView;
    }

    @GetMapping("/chapter/{chapterKey}")
    public ModelAndView chapter(@PathVariable("chapterKey") String chapterKey) {
        ModelAndView modelAndView = new ModelAndView();
        Chapter chapter = learnService.findFirstChapterByKey(chapterKey);
        modelAndView.addObject("chapter", chapter);
        modelAndView.setViewName("chapter");
        return modelAndView;
    }
}
