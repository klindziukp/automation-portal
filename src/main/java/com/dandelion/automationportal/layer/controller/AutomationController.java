package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationRepository.ChapterProjection;
import com.dandelion.automationportal.layer.service.AutomationService;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AutomationController {

    private AutomationService automationService;

    @Autowired
    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @GetMapping("/automation")
    public ModelAndView automation() {
        ModelAndView modelAndView = new ModelAndView();
        List<AutomationTypeProjection> automationTypes = automationService.findAllTypes();
        modelAndView.addObject("automationType", automationTypes);
        modelAndView.setViewName("automationType");
        return modelAndView;
    }

    @GetMapping("/automation/{automationName}")
    public ModelAndView restAutomation(@PathVariable("automationName") String automationName) {
        ModelAndView modelAndView = new ModelAndView();
        String programName = StringUtil.extractName(automationName);
        List<ChapterProjection> chapters = automationService.findChaptersAllByAutomationName(automationName);
        modelAndView.addObject("pageName", programName);
        modelAndView.addObject("automationSubType", chapters);
        modelAndView.setViewName("automationSubType");
        return modelAndView;
    }
}
