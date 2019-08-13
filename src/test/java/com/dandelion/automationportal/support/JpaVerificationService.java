package com.dandelion.automationportal.support;

import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Optional;

public final class JpaVerificationService {

    public void verifyAutomationTypeProjections(List<AutomationTypeProjection> actual, List<AutomationTypeProjection> expected){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actual.size()).as("Sizes are not equal").isEqualTo(expected.size());
        for(int i = 0; i< expected.size(); i++){
            String actualName = Optional.ofNullable(actual.get(i).getName()).orElse("Unable to get actual name.");
            String expectedName = Optional.ofNullable(expected.get(i).getName()).orElse("Unable to get expected name.");
            softAssertions.assertThat(actualName).as("Names are not equal.").isEqualTo(expectedName);

            String actualDescription = Optional.ofNullable(actual.get(i).getDescription()).orElse("Unable to get actual description.");
            String expectedDescription = Optional.ofNullable(expected.get(i).getDescription()).orElse("Unable to get expected description.");
            softAssertions.assertThat(actualDescription).as("Descriptions are not equal.")
                    .isEqualTo(expectedDescription);
        }
        softAssertions.assertAll();
    }

    public void verifyChapterProjections(List<ChapterProjection> actual, List<ChapterProjection> expected){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actual.size()).as("Sizes are not equal").isEqualTo(expected.size());
        for(int i = 0; i< expected.size(); i++){
            String actualName = Optional.ofNullable(actual.get(i).getName()).orElse("Unable to get actual name.");
            String expectedName = Optional.ofNullable(expected.get(i).getName()).orElse("Unable to get expected name.");
            softAssertions.assertThat(actualName).as("Names are not equal.").isEqualTo(expectedName);

            String actualAutomationName = Optional.ofNullable(actual.get(i).getAutomationName()).orElse("Unable to get actual automation name.");
            String expectedAutomationName = Optional.ofNullable(expected.get(i).getAutomationName()).orElse("Unable to get expected automation name.");
            softAssertions.assertThat(actualAutomationName).as("Automation names are not equal.").isEqualTo(expectedAutomationName);

            String actualDescription = Optional.ofNullable(actual.get(i).getDescription()).orElse("Unable to get actual description.");
            String expectedDescription = Optional.ofNullable(expected.get(i).getDescription()).orElse("Unable to get expected description.");
            softAssertions.assertThat(actualDescription).as("Descriptions are not equal.")
                    .isEqualTo(expectedDescription);
        }
        softAssertions.assertAll();
    }

    public void verifyChapterSelfCheckProjection(List<ChapterSelfCheckProjection> actual, List<ChapterSelfCheckProjection> expected){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actual.size()).as("Sizes are not equal").isEqualTo(expected.size());
        for(int i = 0; i< expected.size(); i++){
            String actualName = Optional.ofNullable(actual.get(i).getChapterName()).orElse("Unable to get actual chapter name.");
            String expectedName = Optional.ofNullable(expected.get(i).getChapterName()).orElse("Unable to get expected chapter name.");
            softAssertions.assertThat(actualName).as("Names are not equal.").isEqualTo(expectedName);

            String actualAutomationName = Optional.ofNullable(actual.get(i).getQuestion()).orElse("Unable to get actual question.");
            String expectedAutomationName = Optional.ofNullable(expected.get(i).getQuestion()).orElse("Unable to get actual question.");
            softAssertions.assertThat(actualAutomationName).as("Automation names are not equal.").isEqualTo(expectedAutomationName);

            String actualDescription = Optional.ofNullable(actual.get(i).getAnswer()).orElse("Unable to get actual answer.");
            String expectedDescription = Optional.ofNullable(expected.get(i).getAnswer()).orElse("Unable to get expected answer.");
            softAssertions.assertThat(actualDescription).as("Descriptions are not equal.")
                    .isEqualTo(expectedDescription);
        }
        softAssertions.assertAll();
    }
}
