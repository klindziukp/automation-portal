package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.chapter.Chapter;

import java.util.List;

public interface ChaptersRepository {

    Chapter findFirstChapterByName(String name);
    List<Chapter> findAll();
    List<Chapter> findAllChaptersByName(String name);
}
