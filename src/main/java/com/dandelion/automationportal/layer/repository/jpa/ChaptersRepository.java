package com.dandelion.automationportal.layer.repository.jpa;

import com.dandelion.automationportal.model.jpa.chapter.Chapter;

import java.util.List;

public interface ChaptersRepository {

    Chapter findFirstChapterByKey(String key);
    List<Chapter> findAll();
    List<Chapter> findAllChaptersByKey(String key);
}
