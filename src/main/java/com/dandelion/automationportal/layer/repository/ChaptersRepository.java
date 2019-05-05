package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.Chapter;

import java.util.List;

public interface ChaptersRepository {

    Chapter findFirstChapterByKey(String key);
    List<Chapter> findAll();
}
