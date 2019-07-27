package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.layer.service.ChapterService;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChapterController {

    private ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/self-check/{chapterName}")
    @ResponseBody
    public ModelAndView selfCheck(@PathVariable("chapterName") String chapterName) {
        ModelAndView modelAndView = new ModelAndView();
        List<ChapterSelfCheckProjection> selfCheckQuestions = chapterService.findAllSelfCheckQuestionsByChapterName(chapterName);
        modelAndView.addObject("selfCheckQuestions", selfCheckQuestions);
        modelAndView.addObject("chapterName", StringUtil.extractName(chapterName));
        modelAndView.setViewName("self-check");
        return modelAndView;
    }

    @GetMapping("/chapter/{chapterName}")
    public ModelAndView chapter(@PathVariable("chapterName") String chapterName) {
        ModelAndView modelAndView = new ModelAndView();
        Chapter automationChapter = chapterService.findChapterByName(chapterName);
        final String chapter = "chapter";
        modelAndView.addObject(chapter, automationChapter);
        modelAndView.setViewName(chapter);
        return modelAndView;
    }
}