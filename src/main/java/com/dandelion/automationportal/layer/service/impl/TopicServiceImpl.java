package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.layer.service.TopicService;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicsRepository topicsRepository;

    @Autowired
    public TopicServiceImpl(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    @Override
    public AutomationTopic findTopicByName(String name) {
        return topicsRepository.findByName(name);
    }

    @Override
    public List<AutomationTopic> findAllTopics() {
        return topicsRepository.findAll();
    }
}
