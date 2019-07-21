package com.dandelion.automationportal.layer.controller.jpa;

import com.dandelion.automationportal.layer.service.AutomationJpaService;
import com.dandelion.automationportal.model.chapter.Chapter;
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
    public List<Chapter> restAutomation() {
        return automationJpaService.findAllChapters();
    }

    @GetMapping(value = "api/automation/{automationKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Chapter restAutomation(@PathVariable("automationKey") String automationKey) {
       return automationJpaService.findAllChapters().get(0);
    }
}
