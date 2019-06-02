package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.CodeReviewService;
import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.CodeReviewItem;
import com.dandelion.automationportal.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CodeReviewController {

    private CodeReviewService codeReviewService;
    private ProgramService programService;

    @Autowired
    public CodeReviewController(ProgramService programService, CodeReviewService codeReviewService) {
        this.programService = programService;
        this.codeReviewService = codeReviewService;
    }

    @RequestMapping("/code-review")
    public ModelAndView codeReview() {
        ModelAndView modelAndView = new ModelAndView();
        Program program = programService.findProgramByName("Code Review");
        modelAndView.addObject("program", program);
        modelAndView.setViewName("code-review-list");
        return modelAndView;
    }

    @RequestMapping("/code-review/{topicKey}")
    public ModelAndView codeReviewTopic(@PathVariable("topicKey") String codeReviewKey) {
        ModelAndView modelAndView = new ModelAndView();
        List<CodeReviewItem> allCodeReviewItems = codeReviewService.getCodeReviewItemsByTopicKey(codeReviewKey);
        modelAndView.addObject("codereviewList", allCodeReviewItems);
        modelAndView.setViewName("subcode-review");
        return modelAndView;
    }
}
