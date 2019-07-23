package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.ChapterProjection;
import com.dandelion.automationportal.layer.service.AutomationJpaService;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.support.ProgramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AutomationController {

    private AutomationJpaService automationJpaService;

    @Autowired
    public AutomationController(AutomationJpaService automationJpaService) {
        this.automationJpaService = automationJpaService;
    }

    @GetMapping("/automation")
    public ModelAndView automation() {
        ModelAndView modelAndView = new ModelAndView();
        List<AutomationTypeProjection> automationTypes = automationJpaService.findAllTypes();
        modelAndView.addObject("automationType", automationTypes);
        modelAndView.setViewName("automationType");
        return modelAndView;
    }

    @GetMapping("/automation/{automationName}")
    public ModelAndView restAutomation(@PathVariable("automationName") String automationName) {
        ModelAndView modelAndView = new ModelAndView();
        String programName = ProgramType.getTopicNameByKey(automationName);
        List<ChapterProjection> chapters = automationJpaService.findChaptersAllByAutomationName(automationName);
        modelAndView.addObject("pageName", programName);
        modelAndView.addObject("automationSubType", chapters);
        modelAndView.setViewName("automationSubType");
        return modelAndView;
    }
}
