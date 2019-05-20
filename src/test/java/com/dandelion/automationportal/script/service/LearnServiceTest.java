package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.layer.service.LearnService;
import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import com.dandelion.automationportal.support.TestEntity;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_METHOD)
class LearnServiceTest extends BaseServiceTest {

    private LearnService learnService;
    private TestEntity testEntity;

    @Autowired
    public LearnServiceTest(LearnService learnService, TestEntity testEntity) {
        this.learnService = learnService;
        this.testEntity = testEntity;
    }

    @BeforeEach
    void initEmbeddedService() {
        initEmbeddedService(testEntity, "chapters");
    }

    @Test()
    void findChapterTest() {

        GIVEN();
        Chapter expected = JsonTestDataStorage.getChapters().get(0);

        WHEN();
        Chapter actual = learnService.findFirstChapterByKey(expected.getKey());

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "id");
    }

    @Test()
    void getChapterNameFromKeyTest() {

        GIVEN();
        List<Chapter> chapters = JsonTestDataStorage.getChapters();
        Chapter chapter = chapters.get(new Random().nextInt(chapters.size()));
        String expected = chapter.getKey().toUpperCase();

        WHEN();
        String actual = learnService.getChapterNameFromKey(chapter.getKey());

        THEN();
        assertThat(actual).isEqualTo(expected);
    }

    @Test()
    void getSelfCheckQuestionsTest() {

        GIVEN();
        Chapter chapter = JsonTestDataStorage.getChapters().get(0);
        List<SelfCheckQuestion> expected = JsonTestDataStorage.getSelfCheckQuestions(chapter.getKey());

        WHEN();
        List<SelfCheckQuestion> actual = learnService.findAllByChapterKey(chapter.getKey());

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }
}
