package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.Topic;

import java.util.List;

public interface TopicsRepository {

    Topic findFirstTopicByKey(String key);
    List<Topic> findAll();
    List<Topic> findAllTopicsByKey(String key);
}
