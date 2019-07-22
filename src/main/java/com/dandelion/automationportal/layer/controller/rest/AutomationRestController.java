package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.service.AutomationJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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

    @GetMapping(value = "api/automation/{automationKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public AutomationTypeProjection restAutomation(@PathVariable("automationKey") String automationKey) {
       return automationJpaService.findAllTypes().get(0);
    }
}
