package com.dandelion.automationportal.layer.repository.jpa.impl;

import com.dandelion.automationportal.layer.repository.jpa.AutomationRepository;
import com.dandelion.automationportal.model.jpa.chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationJpaRepository extends JpaRepository<Chapter, Long>, AutomationRepository {

}
