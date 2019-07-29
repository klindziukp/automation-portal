package com.dandelion.automationportal.layer.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutomationRepository {

    interface AutomationTypeProjection {
        String getName();
        String getDescription();
        void setName(String name);
        void setDescription(String description);
    }

    @Query(value = "SELECT name,description FROM automation_type", nativeQuery = true)
    List<AutomationTypeProjection> getNameAndDescriptionOnly();

}
