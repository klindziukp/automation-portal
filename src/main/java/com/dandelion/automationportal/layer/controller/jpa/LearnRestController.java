package com.dandelion.automationportal.layer.controller.jpa;

import com.dandelion.automationportal.layer.service.LearnJpaService;
import com.dandelion.automationportal.model.chapter.SelfCheckQuestion;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LearnRestController {

    private LearnJpaService learnJpaService;

    public LearnRestController(LearnJpaService learnJpaService) {
        this.learnJpaService = learnJpaService;
    }

    @GetMapping(value = "api/self-check/{chapterKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<SelfCheckQuestion> selfCheck(@PathVariable("chapterKey") String chapterKey) {
        return learnJpaService.findAllSelfCheckQuestionsByChapterName(chapterKey);
    }

//    @GetMapping(value = "api/chapter/{chapterKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    @ResponseBody
//    public Chapter chapter(@PathVariable("chapterKey") String chapterKey) {
//        return learnService.findFirstChapterByKey(chapterKey);
//    }
}
