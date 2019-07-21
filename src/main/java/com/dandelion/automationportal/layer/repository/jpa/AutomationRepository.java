package com.dandelion.automationportal.layer.repository.jpa;

import com.dandelion.automationportal.model.jpa.chapter.Chapter;

import java.util.List;

public interface AutomationRepository {

    List<Chapter> findAllChapters();
}
