package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterProjection;
import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.model.chapter.Chapter;

import java.util.List;

public interface ChapterService {

    Chapter findChapterByName(String name);
    List<ChapterProjection> findChaptersAllByAutomationName(String name);
    List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName);
}
