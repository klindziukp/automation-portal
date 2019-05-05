package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProgramController {

    private ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @RequestMapping("/program")
    public ModelAndView program() {
        ModelAndView modelAndView = new ModelAndView();
        Program program = programService.getDefaultProgram();
        modelAndView.addObject("program", program);
        modelAndView.setViewName("program");
        return modelAndView;
    }
}
