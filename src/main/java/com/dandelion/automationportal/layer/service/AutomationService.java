package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationRepository.ChapterProjection;

import java.util.List;

public interface AutomationService {

    List<AutomationTypeProjection> findAllTypes();
    List<ChapterProjection> findChaptersAllByAutomationName(String name);
}
