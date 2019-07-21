package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.chapter.Chapter;

import java.util.List;

public interface AutomationJpaService {

    List<Chapter> findAllChapters();
}
