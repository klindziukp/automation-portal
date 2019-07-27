package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.layer.repository.TopicsRepository.TopicChapterProjection;
import com.dandelion.automationportal.layer.repository.TopicsRepository.TopicProjection;
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
