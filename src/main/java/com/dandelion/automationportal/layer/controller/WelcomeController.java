package com.dandelion.automationportal.layer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping(value = { "/", "/welcome" })
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
}
