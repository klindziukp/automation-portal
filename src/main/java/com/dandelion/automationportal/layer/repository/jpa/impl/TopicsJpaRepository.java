package com.dandelion.automationportal.layer.repository.jpa.impl;

import com.dandelion.automationportal.layer.repository.jpa.TopicsRepository;
import com.dandelion.automationportal.model.jpa.topic.AutomationTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsJpaRepository extends JpaRepository<AutomationTopic, Long>, TopicsRepository {

}
