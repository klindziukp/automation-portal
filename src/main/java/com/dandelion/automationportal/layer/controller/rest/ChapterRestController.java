package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.layer.service.LearnJpaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapterRestController {

    private LearnJpaService learnJpaService;

    public ChapterRestController(LearnJpaService learnJpaService) {
        this.learnJpaService = learnJpaService;
    }

    @GetMapping(value = "api/{chapterName}/self-check", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<ChapterSelfCheckProjection> selfCheck(@PathVariable("chapterName") String chapterName) {
        return learnJpaService.findAllSelfCheckQuestionsByChapterName(chapterName);
    }

//    @GetMapping(value = "api/chapter/{chapterKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    @ResponseBody
//    public Chapter chapter(@PathVariable("chapterKey") String chapterKey) {
//        return learnService.findFirstChapterByKey(chapterKey);
//    }
}
