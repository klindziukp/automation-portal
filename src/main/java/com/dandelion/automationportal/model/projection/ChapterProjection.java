package com.dandelion.automationportal.model.projection;

public interface ChapterProjection {

    String getName();
    String getAutomationName();
    String getDescription();
    void setName(String name);
    void setDescription(String name);
    void setAutomationName(String automationName);
}
