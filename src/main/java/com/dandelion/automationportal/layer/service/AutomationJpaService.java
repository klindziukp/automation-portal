package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.layer.repository.AutomationRepository.AutomationTypeProjection;

import java.util.List;

public interface AutomationJpaService {

    List<AutomationTypeProjection> findAllTypes();
}
