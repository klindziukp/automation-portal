package com.dandelion.automationportal.data;

import com.dandelion.automationportal.model.VocabularyItem;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
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
