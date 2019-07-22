package com.dandelion.automationportal.layer.repository.impl;

import com.dandelion.automationportal.layer.repository.AutomationRepository;
import com.dandelion.automationportal.model.AutomationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationJpaRepository extends JpaRepository<AutomationType, Long>, AutomationRepository {

}
