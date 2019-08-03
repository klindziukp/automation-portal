package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.service.AutomationService;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

class AutomationServiceTest extends BaseServiceTest {

    private AutomationService automationService;

    @Autowired
    public AutomationServiceTest(AutomationService automationService) {
        this.automationService = automationService;
    }

    @Test()
    void getNameAndDescriptionOnlyTest() {
        final List<AutomationTypeProjection> actual = automationService.findAllTypes();
        final List<AutomationTypeProjection> expected = TestDataStorage.testAutomationProjections();
        verifyProjections(actual, expected);
    }

    private void verifyProjections(List<AutomationTypeProjection> actual, List<AutomationTypeProjection> expected){
        SoftAssertions softAssertions = new SoftAssertions();
        for(int i = 0; i< expected.size(); i++){
            String actualName = Optional.ofNullable(actual.get(i).getName()).orElse("Unable to get actual name.");
            String expectedName = Optional.ofNullable(expected.get(i).getName()).orElse("Unable to get expected name.");
            softAssertions.assertThat(actualName).as("Names are not equal.").isEqualTo(expectedName);

            String actualDescription = Optional.ofNullable(actual.get(i).getDescription()).orElse("Unable to get actual description.");
            String expectedDescription = Optional.ofNullable(expected.get(i).getDescription()).orElse("Unable to get expected description.");
            softAssertions.assertThat(actualDescription).as("Descriptions are not equal.")
                    .isEqualTo(expectedDescription);
        }
    }
}