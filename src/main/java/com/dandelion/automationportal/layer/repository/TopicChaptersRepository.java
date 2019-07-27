package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.topic.AutomationTopicChapter;

import java.util.List;

public interface TopicChaptersRepository {

    List<AutomationTopicChapter> findAllByName(String name);
    List<AutomationTopicChapter> findAll();
}
