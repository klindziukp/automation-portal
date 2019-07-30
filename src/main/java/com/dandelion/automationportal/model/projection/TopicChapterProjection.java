package com.dandelion.automationportal.model.projection;

public interface TopicChapterProjection {

    String getAutomationTopicName();
    String getName();
    String getDescription();
    void setAutomationTopicName(String automationTopicName);
    void setName(String name);
    void setDescription(String description);
}
