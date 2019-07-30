package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.projection.TopicChapterProjection;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;

import java.util.List;

public interface TopicService {

    AutomationTopic findTopicByName(String name);
    List<AutomationTopicChapter> findAllByName(String name);
    List<TopicProjection> getNameAndDescriptionOnly();
    List<TopicChapterProjection> findAllChaptersByTopicName(String name);
    List<AutomationTopicChapter> findAllChapters();
    List<AutomationTopic> findAllTopics();
}
