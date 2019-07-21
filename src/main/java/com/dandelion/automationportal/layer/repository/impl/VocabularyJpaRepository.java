package com.dandelion.automationportal.layer.repository.impl;

import com.dandelion.automationportal.layer.repository.VocabularyRepository;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyJpaRepository extends JpaRepository<VocabularyItem, Long>, VocabularyRepository {

}
