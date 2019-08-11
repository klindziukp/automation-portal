package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.service.ChapterService;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapterRestController {

    private ChapterService chapterService;

    public ChapterRestController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping(value = "api/{automationName}/{chapterName}/self-check", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<ChapterSelfCheckProjection> selfCheck(@PathVariable("chapterName") String chapterName) {
        return chapterService.findAllSelfCheckQuestionsByChapterName(chapterName);
    }

    @GetMapping(value = "api/{automationName}/{chapterName}/materials", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Chapter chapter(@PathVariable("chapterName") String chapterName) {
        return chapterService.findChapterByName(chapterName);
    }
}
