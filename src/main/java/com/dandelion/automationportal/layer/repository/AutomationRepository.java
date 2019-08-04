package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.projection.AutomationTypeProjection;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutomationRepository {

    @Query(value = "SELECT name,description FROM automation_type", nativeQuery = true)
    List<AutomationTypeProjection> getAutomationTypes();

}
