package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.layer.repository.AutomationRepository.ChapterProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicsRepository {

    interface TopicProjection {
        String getName();
        String getDescription();
    }

    interface TopicChapterProjection {
        String getAutomationTopicName();
        String getName();
        String getDescription();
    }

    @Query(value = "SELECT name,description FROM automation_topic", nativeQuery = true)
    List<TopicProjection> getNameAndDescriptionOnly();

    @Query(value = "SELECT DISTINCT automation_topic_name as automationTopicName,name,description"
            + " FROM automation_topic_chapter WHERE automation_topic_name = ?1", nativeQuery = true)
    List<TopicChapterProjection> findAllChaptersByTopicName(String name);

    AutomationTopic findByName(String name);

    List<AutomationTopic> findAll();
}
