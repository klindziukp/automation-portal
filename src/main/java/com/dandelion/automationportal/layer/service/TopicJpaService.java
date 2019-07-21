package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.topic.AutomationTopicChapter;

import java.util.List;

public interface TopicJpaService {

    List<AutomationTopicChapter> findAllAutomationTopics();
}
