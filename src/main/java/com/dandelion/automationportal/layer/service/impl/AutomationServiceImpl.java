package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.AutomationJpaRepository;
import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.AutomationTypeProjection;
import com.dandelion.automationportal.layer.repository.AutomationJpaRepository.ChapterProjection;
import com.dandelion.automationportal.layer.service.AutomationJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomationServiceImpl implements AutomationJpaService {

    private AutomationJpaRepository automationJpaRepository;

    @Autowired
    public AutomationServiceImpl(AutomationJpaRepository automationJpaRepository) {
        this.automationJpaRepository = automationJpaRepository;
    }

    @Override
    public List<AutomationTypeProjection> findAllTypes() {
        return automationJpaRepository.getNameAndDescriptionOnly();
    }

    @Override
    public List<ChapterProjection> findChaptersAllByAutomationName(String name) {
       return automationJpaRepository.findChaptersAllByAutomationName(name);
    }
}
