package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.ChapterService;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ChapterController {

    private ChapterService chapterService;
    private Chapter automationChapter;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/{automationName}/{chapterName}/self-check")
    @ResponseBody
    public ModelAndView selfCheck(@PathVariable("chapterName") String chapterName) {
        ModelAndView modelAndView = new ModelAndView();
        automationChapter = getChapterByName(chapterName);
        modelAndView.addObject("selfCheckQuestions", automationChapter.getSelfCheckQuestions());
        modelAndView.addObject("chapterTitle", StringUtil.extractTitle(chapterName));
        modelAndView.addObject("chapterName", automationChapter.getName());
        modelAndView.addObject("automationName", automationChapter.getAutomationName());
        modelAndView.setViewName("self-check");
        return modelAndView;
    }

    @GetMapping("/{automationName}/{chapterName}/materials")
    public ModelAndView chapter(@PathVariable("chapterName") String chapterName) {
        ModelAndView modelAndView = new ModelAndView();
        automationChapter = getChapterByName(chapterName);
        final String chapter = "chapter";
        modelAndView.addObject(chapter, automationChapter);
        modelAndView.setViewName(chapter);
        return modelAndView;
    }

    private Chapter getChapterByName(String chapterName){
        return Optional.ofNullable(automationChapter).orElse(chapterService.findChapterByName(chapterName));
    }
}