package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.AutomationRepository;
import com.dandelion.automationportal.layer.service.AutomationJpaService;
import com.dandelion.automationportal.model.chapter.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomationServiceImpl implements AutomationJpaService {

    private AutomationRepository automationRepository;

    @Autowired
    public AutomationServiceImpl(AutomationRepository automationRepository) {
        this.automationRepository = automationRepository;
    }

    @Override
    public List<Chapter> findAllChapters() {
        return automationRepository.findAll();
    }
}
