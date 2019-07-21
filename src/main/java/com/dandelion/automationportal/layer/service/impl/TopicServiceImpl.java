package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.layer.service.TopicJpaService;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicJpaService {

    private TopicsRepository topicsRepository;

    @Autowired
    public TopicServiceImpl(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    @Override
    public List<AutomationTopicChapter> findAllAutomationTopics() {
        return topicsRepository.findAll();
    }
}
