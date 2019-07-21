package com.dandelion.automationportal.layer.repository.jpa;

import com.dandelion.automationportal.model.jpa.topic.AutomationTopic;

import java.util.List;

public interface TopicsRepository {

    AutomationTopic findFirstTopicByName(String name);
    List<AutomationTopic> findAll();
    List<AutomationTopic> findAllTopicsByName(String name);
}
