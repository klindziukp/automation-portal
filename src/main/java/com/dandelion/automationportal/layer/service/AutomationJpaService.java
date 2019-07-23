package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.ChapterProjection;

import java.util.List;

public interface AutomationJpaService {

    List<AutomationTypeProjection> findAllTypes();
    List<ChapterProjection> findChaptersAllByAutomationName(String name);
}
