package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.support.ProgramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutomationController {

    private ProgramService programService;

    @Autowired
    public AutomationController(ProgramService programService) {
        this.programService = programService;
    }

    @RequestMapping("/automation")
    public ModelAndView automation() {
        ModelAndView modelAndView = new ModelAndView();
        Program program = programService.getDefaultProgram();
        modelAndView.addObject("program", program);
        modelAndView.setViewName("program");
        return modelAndView;
    }

    @RequestMapping("/automation/{automationKey}")
    public ModelAndView automation(@PathVariable("automationKey") String automationKey) {
        ModelAndView modelAndView = new ModelAndView();
        String programName = ProgramType.getTopicNameByKey(automationKey);
        Program program = programService.findProgramByName(programName);
        modelAndView.addObject("program", program);
        modelAndView.addObject("pageName", programName);
        modelAndView.setViewName("subprogram");
        return modelAndView;
    }
}
