package com.dandelion.automationportal.data;

import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import com.dandelion.automationportal.support.Constant;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;

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
}
