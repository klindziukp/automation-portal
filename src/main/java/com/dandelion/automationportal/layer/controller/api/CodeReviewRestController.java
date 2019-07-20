package com.dandelion.automationportal.layer.controller.api;

import com.dandelion.automationportal.layer.service.CodeReviewService;
import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.CodeReviewItem;
import com.dandelion.automationportal.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CodeReviewRestController {

    private CodeReviewService codeReviewService;
    private ProgramService programService;

    @Autowired
    public CodeReviewRestController(ProgramService programService, CodeReviewService codeReviewService) {
        this.programService = programService;
        this.codeReviewService = codeReviewService;
    }

    @GetMapping(value = "api/code-review", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Program codeReview() {
        return programService.findProgramByName("Code Review");
    }

    @GetMapping(value = "api/code-review/{topicKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<CodeReviewItem> codeReviewTopic(@PathVariable("topicKey") String codeReviewKey) {
        return codeReviewService.getCodeReviewItemsByTopicKey(codeReviewKey);
    }
}
