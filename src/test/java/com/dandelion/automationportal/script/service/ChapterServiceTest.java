package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.service.ChapterService;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import com.dandelion.automationportal.support.Constant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;

class ChapterServiceTest extends BaseServiceScript {

    private ChapterService chapterService;

    @Autowired
    public ChapterServiceTest(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @Test()
    void findAllChaptersByAutomationNameTest() {

        GIVEN();
        final List<ChapterProjection> expected = TestDataStorage.getChapterProjections();

        WHEN();
        final List<ChapterProjection> actual = chapterService.findChaptersAllByAutomationName(Constant.AUTOMATION_NAME);

        THEN();
        jpaVerificationService.verifyChapterProjections(actual, expected);
    }

    @Test()
    void findAllSelfCheckQuestionsByChapterNameTest() {

        GIVEN();
        final List<ChapterSelfCheckProjection> expected = TestDataStorage.getSelfCheckChapterProjections();

        WHEN();
        final List<ChapterSelfCheckProjection> actual = chapterService.findAllSelfCheckQuestionsByChapterName(Constant.CHAPTER_NAME);

        THEN();
        jpaVerificationService.verifyChapterSelfCheckProjection(actual, expected);
    }
}