package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import com.dandelion.automationportal.support.Constant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;

class ChaptersJpaRepositoryTest extends BaseRepositoryScript {

    private ChaptersRepository chaptersRepository;

    @Autowired
    public ChaptersJpaRepositoryTest(ChaptersRepository chaptersRepository) {
        this.chaptersRepository = chaptersRepository;
    }

    @Test()
    void findAllChaptersByAutomationNameTest() {

        GIVEN();
        List<ChapterProjection> expected = TestDataStorage.getChapterProjections();

        WHEN();
        List<ChapterProjection> actual = chaptersRepository.findAllChaptersByAutomationName(Constant.
                AUTOMATION_NAME);

        THEN();
        jpaVerificationService.verifyChapterProjections(actual, expected);
    }

    @Test()
    void findAllSelfCheckQuestionsByChapterNameTest() {

        GIVEN();
        final List<ChapterSelfCheckProjection> expected = TestDataStorage.getSelfCheckChapterProjections();

        WHEN();
        final List<ChapterSelfCheckProjection> actual = chaptersRepository.findAllSelfCheckQuestionsByChapterName(Constant.CHAPTER_NAME);

        THEN();
        jpaVerificationService.verifyChapterSelfCheckProjection(actual, expected);
    }
}