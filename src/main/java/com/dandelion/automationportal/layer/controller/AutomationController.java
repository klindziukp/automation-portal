package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.service.AutomationJpaService;
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

    @GetMapping("/automation/{automationKey}")
    public AutomationTypeProjection restAutomation(@PathVariable("automationKey") String automationKey) {
       return automationJpaService.findAllTypes().get(0);
    }
}
