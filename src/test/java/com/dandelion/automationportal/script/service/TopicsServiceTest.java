package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.service.TopicService;
import com.dandelion.automationportal.model.projection.TopicChapterProjection;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
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

class TopicsServiceTest extends BaseServiceScript {

    private TopicService topicService;

    @Autowired
    public TopicsServiceTest(TopicService topicService) {
        this.topicService = topicService;
    }

    @Test()
    void getNameAndDescriptionOnlyTest() {

        GIVEN();
        List<TopicProjection> expected = TestDataStorage.getTopicProjections();

        WHEN();
        List<TopicProjection> actual = topicService.getNameAndDescriptionOnly();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getUpdatableEntityFields()).isEqualTo(expected);
    }

    @Test()
    void findTopicByNameTest() {
        GIVEN();
        AutomationTopic expected = TestDataStorage.getAutomationTopic();

        WHEN();
        AutomationTopic actual = topicService.findTopicByName(Constant.AUTOMATION_TOPIC_NAME_FIRST);

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "topicChapters");
    }

    @Test()
    void findAllByNameTest() {
        GIVEN();
        List<AutomationTopicChapter> expected = TestDataStorage.getAutomationTopicChaptersByName(
                Constant.AUTOMATION_TOPIC_NAME_FIRST);

        WHEN();
        List<AutomationTopicChapter> actual = topicService.findAllByName(Constant.AUTOMATION_TOPIC_NAME_FIRST);

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getAutomationTopicIgnoreFields()).isEqualTo(expected);
    }

    @Test()
    void findAllChaptersByTopicNameTest() {

        List<TopicChapterProjection> expected = TestDataStorage.getTopicChapterProjections();

        WHEN();
        List<TopicChapterProjection> actual = topicService.findAllChaptersByTopicName(Constant.AUTOMATION_TOPIC_NAME_FIRST);

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getUpdatableEntityFields()).isEqualTo(expected);
    }

    @Test()
    void findAllChaptersTest() {
        GIVEN();
        List<AutomationTopicChapter> expected = TestDataStorage.getAutomationTopicChapters();

        WHEN();
        List<AutomationTopicChapter> actual = topicService.findAllChapters();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getAutomationTopicIgnoreFields()).isEqualTo(
                expected);
    }

    @Test()
    void findAllTopicsTest() {
        GIVEN();
        List<AutomationTopic> expected = TestDataStorage.getAutomationTopics();

        WHEN();
        List<AutomationTopic> actual = topicService.findAllTopics();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields("topicChapters").isEqualTo(expected);
   }
}