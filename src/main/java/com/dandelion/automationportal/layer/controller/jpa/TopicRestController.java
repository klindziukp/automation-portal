package com.dandelion.automationportal.layer.controller.jpa;

import com.dandelion.automationportal.layer.service.TopicJpaService;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicRestController {

    private TopicJpaService topicJpaService;

    @Autowired
    public TopicRestController(TopicJpaService topicJpaService) {
        this.topicJpaService = topicJpaService;
    }

    @GetMapping(value = "api/topics", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<AutomationTopicChapter> topics() {
       return topicJpaService.findAllAutomationTopics();
    }

    @GetMapping(value = "api/code-review/{topicKey}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public AutomationTopic topic(@PathVariable("topicKey") String codeReviewKey) {
        return null;
    }
}
