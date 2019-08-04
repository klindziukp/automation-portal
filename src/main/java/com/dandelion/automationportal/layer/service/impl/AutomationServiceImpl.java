package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.AutomationRepository;
import com.dandelion.automationportal.layer.service.AutomationService;
import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomationServiceImpl implements AutomationService {

    private AutomationRepository automationRepository;

    @Autowired
    public AutomationServiceImpl(AutomationRepository automationRepository) {
        this.automationRepository = automationRepository;
    }

    @Override
    public List<AutomationTypeProjection> findAllTypes() {
        return automationRepository.getAutomationTypes();
    }
}
