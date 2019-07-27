package com.dandelion.automationportal.layer.repository.impl;

import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.model.topic.AutomationTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsJpaRepository extends JpaRepository<AutomationTopic, Long>, TopicsRepository {

}
