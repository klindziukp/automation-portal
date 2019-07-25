package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.layer.service.ChapterJpaService;
import com.dandelion.automationportal.layer.service.VocabularyJpaService;
import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.model.chapter.SelfCheckQuestion;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChapterController {

    private ChapterJpaService chapterJpaService;

    public ChapterController(ChapterJpaService chapterJpaService) {
        this.chapterJpaService = chapterJpaService;
    }

    @GetMapping("/self-check/{chapterName}")
    @ResponseBody
    public ModelAndView selfCheck(@PathVariable("chapterName") String chapterName) {
        ModelAndView modelAndView = new ModelAndView();
        List<ChapterSelfCheckProjection> selfCheckQuestions = chapterJpaService.findAllSelfCheckQuestionsByChapterName(chapterName);
        modelAndView.addObject("selfCheckQuestions", selfCheckQuestions);
        modelAndView.addObject("chapterName", StringUtil.getChapterNameFromKey(chapterName));
        modelAndView.setViewName("self-check");
        return modelAndView;
    }

    @GetMapping("/chapter/{chapterName}")
    public ModelAndView chapter(@PathVariable("chapterName") String chapterName) {
        ModelAndView modelAndView = new ModelAndView();
        Chapter chapter = chapterJpaService.findChapterByName(chapterName);
        modelAndView.addObject("chapter", chapter);
        modelAndView.setViewName("chapter");
        return modelAndView;
    }
}