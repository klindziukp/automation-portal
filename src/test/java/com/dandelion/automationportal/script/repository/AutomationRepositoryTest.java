package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.repository.AutomationRepository;
import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

class AutomationRepositoryTest extends BaseRepositoryTest {

    private AutomationRepository automationRepository;

    @Autowired
    public AutomationRepositoryTest(AutomationRepository automationRepository) {
        this.automationRepository = automationRepository;
    }

    @Test()
    void getNameAndDescriptionOnlyTest() {
        final List<AutomationTypeProjection> actual = automationRepository.getNameAndDescriptionOnly();
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