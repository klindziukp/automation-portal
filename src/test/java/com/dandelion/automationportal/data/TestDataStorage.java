package com.dandelion.automationportal.data;

import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;

public final class TestDataStorage {

    private static ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    private TestDataStorage() {
    }

    public static List<AutomationTypeProjection> testAutomationProjections() {
        AutomationTypeProjection firstProjection = factory.createProjection(AutomationTypeProjection.class);
        firstProjection.setName("first-automation-type");
        firstProjection.setDescription("First Automation Type");

        AutomationTypeProjection secondProjection = factory.createProjection(AutomationTypeProjection.class);
        firstProjection.setName("second-automation-type");
        firstProjection.setDescription("Second Automation Type");

        List<AutomationTypeProjection> projections = new ArrayList<>();
        projections.add(firstProjection);
        projections.add(secondProjection);
        return projections;
    }
}
