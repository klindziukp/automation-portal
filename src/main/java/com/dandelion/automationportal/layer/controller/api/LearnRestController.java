package com.dandelion.automationportal.layer.controller.api;

import com.dandelion.automationportal.layer.service.LearnService;
import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LearnRestController {

    private LearnService learnService;

    @Autowired
    public LearnRestController(LearnService learnService) {
        this.learnService = learnService;
    }

    @GetMapping(value = "api/self-check/{chapterKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<SelfCheckQuestion> selfCheck(@PathVariable("chapterKey") String chapterKey) {
        return learnService.findAllByChapterKey(chapterKey);
    }

    @GetMapping(value = "api/chapter/{chapterKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Chapter chapter(@PathVariable("chapterKey") String chapterKey) {
        return learnService.findFirstChapterByKey(chapterKey);
    }
}
