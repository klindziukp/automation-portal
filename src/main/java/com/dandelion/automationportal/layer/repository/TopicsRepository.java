package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.topic.AutomationTopicChapter;

import java.util.List;

public interface TopicsRepository {

    AutomationTopicChapter findFirstTopicByName(String name);
    List<AutomationTopicChapter> findAll();
    List<AutomationTopicChapter> findAllTopicsByName(String name);
}
