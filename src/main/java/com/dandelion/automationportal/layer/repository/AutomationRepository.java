package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.AutomationType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutomationRepository {

     interface AutomationTypeProjection {
        String getName();
        String getDescription();
    }

    List<AutomationType> findAll();

    @Query(value = "SELECT name,description FROM automation_type", nativeQuery = true)
    List<AutomationTypeProjection> getNameAndDescriptionOnly();
}
