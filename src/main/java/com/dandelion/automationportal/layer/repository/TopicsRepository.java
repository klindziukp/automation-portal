package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.topic.AutomationTopic;

import java.util.List;

public interface TopicsRepository {

    AutomationTopic findByName(String name);
    List<AutomationTopic> findAll();
}
