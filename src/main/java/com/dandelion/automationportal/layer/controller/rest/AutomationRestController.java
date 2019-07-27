package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationRepository.ChapterProjection;
import com.dandelion.automationportal.layer.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomationRestController {

    private AutomationService automationService;

    @Autowired
    public AutomationRestController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @GetMapping(value = "/api/automation", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<AutomationTypeProjection> restAutomation() {
        return automationService.findAllTypes();
    }

    @GetMapping(value = "api/automation/{automationName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<ChapterProjection> chapters(@PathVariable("automationName") String automationName) {
        return automationService.findChaptersAllByAutomationName(automationName);
    }
}
