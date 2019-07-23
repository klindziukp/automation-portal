package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.ChapterProjection;
import com.dandelion.automationportal.layer.service.AutomationJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomationRestController {

    private AutomationJpaService automationJpaService;

    @Autowired
    public AutomationRestController(AutomationJpaService automationJpaService) {
        this.automationJpaService = automationJpaService;
    }

    @GetMapping(value = "/api/automation", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<AutomationTypeProjection> restAutomation() {
        return automationJpaService.findAllTypes();
    }

    @GetMapping(value = "api/automation/{automationName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<ChapterProjection> chapters(@PathVariable("automationName") String automationName) {
        return automationJpaService.findChaptersAllByAutomationName(automationName);
    }
}
