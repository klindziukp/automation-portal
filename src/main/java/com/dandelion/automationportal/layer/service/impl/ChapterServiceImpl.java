package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.layer.service.ChapterService;
import com.dandelion.automationportal.model.chapter.Chapter;
import com.dandelion.automationportal.model.projection.ChapterProjection;
import com.dandelion.automationportal.model.projection.ChapterSelfCheckProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    private ChaptersRepository chaptersJpaRepository;

    @Autowired
    public ChapterServiceImpl(ChaptersRepository chaptersJpaRepository) {
        this.chaptersJpaRepository = chaptersJpaRepository;
    }

    @Override
    public Chapter findChapterByName(String name) {
        return chaptersJpaRepository.findChapterByName(name);
    }

    @Override
    public List<ChapterProjection> findChaptersAllByAutomationName(String name) {
        return chaptersJpaRepository.findAllChaptersByAutomationName(name);
    }

    @Override
    public List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName) {
        return chaptersJpaRepository.findAllSelfCheckQuestionsByChapterName(chapterName);
    }
}
