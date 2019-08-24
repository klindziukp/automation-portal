package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.model.projection.TopicChapterProjection;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.support.Constant;
import com.dandelion.automationportal.support.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class TopicsJpaRepositoryTest extends BaseRepositoryScript {

    private TopicsRepository topicsRepository;

    @Autowired
    public TopicsJpaRepositoryTest(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    @Test()
    void getNameAndDescriptionOnlyTest() {

        GIVEN();
        List<TopicProjection> expected = TestDataStorage.getTopicProjections();

        WHEN();
        List<TopicProjection> actual = topicsRepository.getNameAndDescriptionOnly();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getUpdatableEntityFields()).isEqualTo(expected);
    }

    @Test()
    void findAllChaptersByTopicNameTest() {

        GIVEN();
        List<TopicChapterProjection> expected = TestDataStorage.getTopicChapterProjections();

        WHEN();
        List<TopicChapterProjection> actual = topicsRepository.findAllChaptersByTopicName(Constant.AUTOMATION_TOPIC_NAME_FIRST);

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields(Ignore.getUpdatableEntityFields()).isEqualTo(expected);
    }

    @Test
    void findByNameTest() {

        GIVEN();
        AutomationTopic expected = TestDataStorage.getAutomationTopic();

        WHEN();
        AutomationTopic actual = topicsRepository.findByName(Constant.AUTOMATION_TOPIC_NAME_FIRST);

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "topicChapters");
    }

    @Test
    void findAllTest() {

        GIVEN();
        List<AutomationTopic> expected = TestDataStorage.getAutomationTopics();

        WHEN();
        List<AutomationTopic> actual = topicsRepository.findAll();

        THEN();
        assertThat(actual).usingElementComparatorIgnoringFields("topicChapters").isEqualTo(expected);
    }
}