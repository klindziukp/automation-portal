package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.chapter.Chapter;

import java.util.List;

public interface AutomationRepository {

    List<Chapter> findAll();
}
