package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.topic.AutomationTopic;
import java.util.List;

public interface TopicService {

    AutomationTopic findTopicByName(String name);
    List<AutomationTopic> findAllTopics();
}
