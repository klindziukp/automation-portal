package com.dandelion.automationportal.layer.controller;

import com.dandelion.automationportal.layer.service.TopicService;
import com.dandelion.automationportal.model.projection.TopicChapterProjection;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public ModelAndView topics() {
        ModelAndView modelAndView = new ModelAndView();
        List<TopicProjection> topics = topicService.getNameAndDescriptionOnly();
        modelAndView.addObject("topics", topics);
        modelAndView.setViewName("automationTopic");
        return modelAndView;
    }

    @GetMapping(value = "/topics/{topicName}")
    public ModelAndView topicChapters(@PathVariable("topicName") String topicName) {
        ModelAndView modelAndView = new ModelAndView();
        List<TopicChapterProjection> topicChapters = topicService.findAllChaptersByTopicName(topicName);
        modelAndView.addObject("topicChapters", topicChapters);
        modelAndView.setViewName("automationTopicChapter");
        String pageName = StringUtil.extractTitle(topicName);
        modelAndView.addObject("pageName", pageName);
        return modelAndView;
    }

    @GetMapping(value = "/topics/{topicName}/{topicChapterName}")
    public ModelAndView topicChapter(@PathVariable("topicName") String topicName, @PathVariable("topicChapterName") String topicChapterName) {
        ModelAndView modelAndView = new ModelAndView();
        List<AutomationTopicChapter> topicChapters = topicService.findAllByName(topicChapterName);
        modelAndView.addObject("topicChapters", topicChapters);
        modelAndView.setViewName("topic");
        String pageName = StringUtil.extractTitle(topicName);
        modelAndView.addObject("pageName", pageName);
        return modelAndView;
    }
}
