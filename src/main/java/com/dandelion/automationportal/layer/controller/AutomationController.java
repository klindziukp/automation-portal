package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.support.ProgramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutomationController {

    private static final String PROGRAM = "program";

    private ProgramService programService;

    @Autowired
    public AutomationController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/automation")
    public ModelAndView automation() {
        ModelAndView modelAndView = new ModelAndView();
        Program program = programService.getDefaultProgram();
        modelAndView.addObject(PROGRAM, program);
        modelAndView.setViewName(PROGRAM);
        return modelAndView;
    }

    @GetMapping("/automation/{automationKey}")
    public ModelAndView automation(@PathVariable("automationKey") String automationKey) {
        ModelAndView modelAndView = new ModelAndView();
        String programName = ProgramType.getTopicNameByKey(automationKey);
        Program program = programService.findProgramByName(programName);
        modelAndView.addObject(PROGRAM, program);
        modelAndView.addObject("pageName", programName);
        modelAndView.setViewName("subprogram");
        return modelAndView;
    }
}
