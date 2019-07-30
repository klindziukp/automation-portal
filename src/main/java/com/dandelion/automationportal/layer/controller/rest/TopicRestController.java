package com.dandelion.automationportal.layer.controller.rest;

import com.dandelion.automationportal.layer.service.TopicService;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public List<TopicProjection> topics() {
        return topicService.getNameAndDescriptionOnly();
    }

    @GetMapping(value = "api/topics/{topicName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public AutomationTopic topic(@PathVariable("topicName") String topicName) {
        return topicService.findTopicByName(topicName);
    }

    @GetMapping(value = "api/topics/{topicName}/{topicChapterName}")
    @ResponseBody
    public List<AutomationTopicChapter> topicChapters(@PathVariable("topicName") String topicName,
                                                      @PathVariable("topicChapterName") String topicChapterName) {
        return topicService.findAllByName(topicChapterName);
    }
}
