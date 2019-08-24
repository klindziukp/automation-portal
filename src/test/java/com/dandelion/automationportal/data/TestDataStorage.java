package com.dandelion.automationportal.data;

import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import com.dandelion.automationportal.model.projection.TopicChapterProjection;
import com.dandelion.automationportal.model.projection.TopicProjection;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import com.dandelion.automationportal.model.topic.AutomationTopicChapter;
import com.dandelion.automationportal.support.Constant;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TestDataStorage {

    private static ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    private TestDataStorage() {
    }

    public static List<AutomationTypeProjection> getTestAutomationProjections() {
        AutomationTypeProjection firstProjection = factory.createProjection(AutomationTypeProjection.class);
        firstProjection.setName("first-automation-type");
        firstProjection.setDescription("First Automation Type");

        AutomationTypeProjection secondProjection = factory.createProjection(AutomationTypeProjection.class);
        secondProjection.setName("second-automation-type");
        secondProjection.setDescription("Second Automation Type");

        List<AutomationTypeProjection> projections = new ArrayList<>();
        projections.add(firstProjection);
        projections.add(secondProjection);
        return projections;
    }

    public static List<ChapterProjection> getChapterProjections() {
        ChapterProjection firstProjection = factory.createProjection(ChapterProjection.class);
        firstProjection.setName(Constant.CHAPTER_NAME);
        firstProjection.setAutomationName(Constant.AUTOMATION_NAME);
        firstProjection.setDescription("test-description-0");

        ChapterProjection secondProjection = factory.createProjection(ChapterProjection.class);
        secondProjection.setName(Constant.CHAPTER_NAME);
        secondProjection.setAutomationName(Constant.AUTOMATION_NAME);
        secondProjection.setDescription("test-description-1");

        List<ChapterProjection> projections = new ArrayList<>();
        projections.add(firstProjection);
        projections.add(secondProjection);
        return projections;
    }

    public static List<ChapterSelfCheckProjection> getSelfCheckChapterProjections() {
        ChapterSelfCheckProjection firstProjection = factory.createProjection(ChapterSelfCheckProjection.class);

        firstProjection.setChapterName(Constant.CHAPTER_NAME);
        firstProjection.setQuestion("Test-self-check-question-0");
        firstProjection.setAnswer("Test-self-check-answer-0");

        ChapterSelfCheckProjection secondProjection = factory.createProjection(ChapterSelfCheckProjection.class);
        secondProjection.setChapterName(Constant.CHAPTER_NAME);
        secondProjection.setQuestion("Test-self-check-question-1");
        secondProjection.setAnswer("Test-self-check-answer-1");

        List<ChapterSelfCheckProjection> projections = new ArrayList<>();
        projections.add(firstProjection);
        projections.add(secondProjection);
        return projections;
    }

    public static List<VocabularyItem> getTestVocabularyItems(){
        VocabularyItem firsItem = new VocabularyItem();
        firsItem.setKey("FirstTestKeyword");
        firsItem.setValue("FirstTestValue");
        firsItem.setCreatedBy("FirstTestDandelion");

        VocabularyItem secondItem = new VocabularyItem();
        secondItem.setKey("SecondTestKeyword");
        secondItem.setValue("SecondTestValue");
        secondItem.setCreatedBy("SecondTestDandelion");

        List<VocabularyItem> vocabularyItems = new ArrayList<>();
        vocabularyItems.add(firsItem);
        vocabularyItems.add(secondItem);
        return vocabularyItems;
    }

    public static List<TopicProjection> getTopicProjections() {
        TopicProjection firstProjection = factory.createProjection(TopicProjection.class);

        firstProjection.setName(Constant.AUTOMATION_TOPIC_NAME_FIRST);
        firstProjection.setDescription(Constant.AUTOMATION_TOPIC_DESCRIPTION_FIRST);

        TopicProjection secondProjection = factory.createProjection(TopicProjection.class);

        secondProjection.setName(Constant.AUTOMATION_TOPIC_NAME_SECOND);
        secondProjection.setDescription(Constant.AUTOMATION_TOPIC_DESCRIPTION_SECOND);

        List<TopicProjection> projections = new ArrayList<>();
        projections.add(firstProjection);
        projections.add(secondProjection);
        return projections;
    }

    public static List<TopicChapterProjection> getTopicChapterProjections() {
        TopicChapterProjection firstProjection = factory.createProjection(TopicChapterProjection.class);

        firstProjection.setAutomationTopicName(Constant.AUTOMATION_TOPIC_NAME_FIRST);
        firstProjection.setName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_FIRST);
        firstProjection.setDescription(Constant.AUTOMATION_TOPIC_CHAPTER_DESCRIPTION_FIRST);

        TopicChapterProjection secondProjection = factory.createProjection(TopicChapterProjection.class);

        secondProjection.setAutomationTopicName(Constant.AUTOMATION_TOPIC_NAME_FIRST);
        secondProjection.setName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_SECOND);
        secondProjection.setDescription(Constant.AUTOMATION_TOPIC_CHAPTER_DESCRIPTION_SECOND);

        List<TopicChapterProjection> projections = new ArrayList<>();
        projections.add(firstProjection);
        projections.add(secondProjection);
        return projections;
    }

    public static List<AutomationTopicChapter> getAutomationTopicChaptersByName(String name) {
        return getAutomationTopicChapters().stream().filter(topic -> topic.getName().equals(name)).collect(
                Collectors.toList());
    }

    public static List<AutomationTopicChapter> getAutomationTopicChapters(){
        AutomationTopicChapter firstAutomationTopicChapter = new AutomationTopicChapter();
        firstAutomationTopicChapter.setAutomationTopicName(Constant.AUTOMATION_TOPIC_NAME_FIRST);
        firstAutomationTopicChapter.setName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_FIRST);
        firstAutomationTopicChapter.setDescription(Constant.AUTOMATION_TOPIC_CHAPTER_DESCRIPTION_FIRST);
        firstAutomationTopicChapter.setKey("test-key-word-0");
        firstAutomationTopicChapter.setBeginWith("test-begin-with-0");
        firstAutomationTopicChapter.setText("test-text-0");

        AutomationTopicChapter secondAutomationTopicChapter = new AutomationTopicChapter();
        secondAutomationTopicChapter.setAutomationTopicName(Constant.AUTOMATION_TOPIC_NAME_FIRST);
        secondAutomationTopicChapter.setName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_SECOND);
        secondAutomationTopicChapter.setDescription(Constant.AUTOMATION_TOPIC_CHAPTER_DESCRIPTION_SECOND);
        secondAutomationTopicChapter.setKey("test-key-word-1");
        secondAutomationTopicChapter.setBeginWith("test-begin-with-1");
        secondAutomationTopicChapter.setText("test-text-1");

        AutomationTopicChapter thirdAutomationTopicChapter = new AutomationTopicChapter();
        thirdAutomationTopicChapter.setAutomationTopicName(Constant.AUTOMATION_TOPIC_NAME_SECOND);
        thirdAutomationTopicChapter.setName(Constant.AUTOMATION_TOPIC_CHAPTER_NAME_THIRD);
        thirdAutomationTopicChapter.setDescription(Constant.AUTOMATION_TOPIC_CHAPTER_DESCRIPTION_THIRD);
        thirdAutomationTopicChapter.setKey("test-key-word-2");
        thirdAutomationTopicChapter.setBeginWith("test-begin-with-2");
        thirdAutomationTopicChapter.setText("test-text-2");

        List<AutomationTopicChapter> automationTopicChapters = new ArrayList<>();
        automationTopicChapters.add(firstAutomationTopicChapter);
        automationTopicChapters.add(secondAutomationTopicChapter);
        automationTopicChapters.add(thirdAutomationTopicChapter);
        return automationTopicChapters;
    }

    public static AutomationTopic getAutomationTopic() {
        AutomationTopic automationTopic = new AutomationTopic();
        automationTopic.setId(100L);
        automationTopic.setName(Constant.AUTOMATION_TOPIC_NAME_FIRST);
        automationTopic.setDescription(Constant.AUTOMATION_TOPIC_DESCRIPTION_FIRST);
        automationTopic.setTopicChapters(getAutomationTopicChapters());

        return automationTopic;
    }

    public static List<AutomationTopic> getAutomationTopics() {
        AutomationTopic firstAutomationTopic = getAutomationTopic();
        AutomationTopic secondAutomationTopic = new AutomationTopic();
        secondAutomationTopic.setId(101L);
        secondAutomationTopic.setName(Constant.AUTOMATION_TOPIC_NAME_SECOND);
        secondAutomationTopic.setDescription(Constant.AUTOMATION_TOPIC_DESCRIPTION_SECOND);
        List<AutomationTopic> automationTopics = new ArrayList<>();
        automationTopics.add(firstAutomationTopic);
        automationTopics.add(secondAutomationTopic);

        return automationTopics;
    }
}
