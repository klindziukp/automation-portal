package com.dandelion.automationportal.layer.repository.jpa;

import com.dandelion.automationportal.model.jpa.VocabularyItem;

import java.util.List;

public interface VocabularyRepository {

    List<VocabularyItem> findAllByOrderByKeyAsc();
}
