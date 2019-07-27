package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.service.TopicService;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicRestController {

    private TopicService topicService;

    @Autowired
    public TopicRestController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(value = "api/topics", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<AutomationTopic> topics() {
        return topicService.findAllTopics();
    }

    @GetMapping(value = "api/topics/{topicName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public AutomationTopic topic(@PathVariable("topicName") String topicName) {
        return topicService.findTopicByName(topicName);
    }
}
