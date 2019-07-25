package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.layer.service.ChapterJpaService;
import com.dandelion.automationportal.model.chapter.Chapter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapterRestController {

    private ChapterJpaService chapterJpaService;

    public ChapterRestController(ChapterJpaService chapterJpaService) {
        this.chapterJpaService = chapterJpaService;
    }

    @GetMapping(value = "api/self-check/{chapterName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<ChapterSelfCheckProjection> selfCheck(@PathVariable("chapterName") String chapterName) {
        return chapterJpaService.findAllSelfCheckQuestionsByChapterName(chapterName);
    }

    @GetMapping(value = "api/chapter/{chapterName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Chapter chapter(@PathVariable("chapterName") String chapterName) {
        return chapterJpaService.findChapterByName(chapterName);
    }
}
