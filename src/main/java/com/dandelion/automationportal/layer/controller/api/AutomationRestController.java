package com.dandelion.automationportal.layer.controller.api;

import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.support.ProgramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutomationRestController {

    private ProgramService programService;

    @Autowired
    public AutomationRestController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping(value = "/api/automation", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Program restAutomation() {
        return programService.getDefaultProgram();
    }

    @GetMapping(value = "api/automation/{automationKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Program restAutomation(@PathVariable("automationKey") String automationKey) {
        String programName = ProgramType.getTopicNameByKey(automationKey);
        return programService.findProgramByName(programName);
    }
}
