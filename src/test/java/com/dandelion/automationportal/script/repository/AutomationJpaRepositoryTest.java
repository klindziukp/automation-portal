package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.data.TestDataStorage;
import com.dandelion.automationportal.layer.repository.AutomationRepository;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;

class AutomationJpaRepositoryTest extends BaseRepositoryScript {

    private AutomationRepository automationRepository;

    @Autowired
    public AutomationJpaRepositoryTest(AutomationRepository automationRepository) {
        this.automationRepository = automationRepository;
    }

    @Test()
    void getNameAndDescriptionOnlyTest() {

        GIVEN();
        final List<AutomationTypeProjection> expected = TestDataStorage.getTestAutomationProjections();

        WHEN();
        final List<AutomationTypeProjection> actual = automationRepository.getAutomationTypes();

        THEN();
        jpaVerificationService.verifyAutomationTypeProjections(actual, expected);
    }
}