package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.repository.TopicChaptersRepository;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import com.dandelion.automationportal.support.Constant;
import com.dandelion.automationportal.support.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class TopicsChapterJpaRepositoryTest extends BaseRepositoryScript {

    private TopicChaptersRepository topicChaptersRepository;

    @Autowired
    public TopicsChapterJpaRepositoryTest(TopicChaptersRepository topicChaptersRepository) {
        this.topicChaptersRepository = topicChaptersRepository;
    }

    @Test()
    void findAllByNameTest() {

        GIVEN();
        List<AutomationTopicChapter> expected = TestDataStorage.getAutomationTopicChaptersByName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_FIRST);

        WHEN();
        List<AutomationTopicChapter> actual = topicChaptersRepository.findAllByName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_FIRST);

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getAutomationTopicIgnoreFields()).isEqualTo(expected);

    }

    @Test()
    void findAllTest() {

        GIVEN();
        List<AutomationTopicChapter> expected = TestDataStorage.getAutomationTopicChapters();

        WHEN();
        List<AutomationTopicChapter> actual = topicChaptersRepository.findAll();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getAutomationTopicIgnoreFields()).isEqualTo(expected);
    }
}