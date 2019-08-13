package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.service.AutomationService;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;

class AutomationServiceTest extends BaseServiceScript {

    private AutomationService automationService;

    @Autowired
    public AutomationServiceTest(AutomationService automationService) {
        this.automationService = automationService;
    }

    @Test()
    void getNameAndDescriptionOnlyTest() {

        GIVEN();
        List<AutomationTypeProjection> actual = automationService.findAllTypes();

        WHEN();
        List<AutomationTypeProjection> expected = TestDataStorage.getTestAutomationProjections();

        THEN();
        jpaVerificationService.verifyAutomationTypeProjections(actual, expected);
    }
}