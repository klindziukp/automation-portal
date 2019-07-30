package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.TopicChaptersRepository;
import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.layer.service.TopicService;
import com.dandelion.automationportal.model.projection.TopicChapterProjection;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicsRepository topicsRepository;
    private TopicChaptersRepository topicChaptersRepository;

    @Autowired
    public TopicServiceImpl(TopicsRepository topicsRepository, TopicChaptersRepository topicChaptersRepository) {
        this.topicsRepository = topicsRepository;
        this.topicChaptersRepository = topicChaptersRepository;
    }

    @Override
    public AutomationTopic findTopicByName(String name) {
        return topicsRepository.findByName(name);
    }

    @Override
    public List<AutomationTopicChapter> findAllByName(String name) {
        return topicChaptersRepository.findAllByName(name);
    }

    @Override
    public List<TopicProjection> getNameAndDescriptionOnly() {
        return topicsRepository.getNameAndDescriptionOnly();
    }

    @Override
    public List<TopicChapterProjection> findAllChaptersByTopicName(String name) {
       return topicsRepository.findAllChaptersByTopicName(name);
    }

    @Override
    public List<AutomationTopicChapter> findAllChapters() {
        return topicChaptersRepository.findAll();
    }

    @Override
    public List<AutomationTopic> findAllTopics() {
        return topicsRepository.findAll();
    }
}
