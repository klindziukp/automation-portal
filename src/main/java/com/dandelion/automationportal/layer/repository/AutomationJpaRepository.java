package com.dandelion.automationportal.layer.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutomationJpaRepository {

    interface AutomationTypeProjection {
        String getName();
        String getDescription();
    }

    interface ChapterProjection {
        String getName();
        String getDescription();
    }

    @Query(value = "SELECT name,description FROM automation_type", nativeQuery = true)
    List<AutomationTypeProjection> getNameAndDescriptionOnly();

    @Query(value = "SELECT name,description FROM chapter WHERE automation_name = ?1", nativeQuery = true)
    List<ChapterProjection> findChaptersAllByAutomationName(String name);
}
