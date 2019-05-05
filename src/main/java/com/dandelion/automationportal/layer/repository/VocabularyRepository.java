package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.VocabularyItem;

import java.util.List;

public interface VocabularyRepository {

    List<VocabularyItem> findAllByOrderByKeyAsc();
}
