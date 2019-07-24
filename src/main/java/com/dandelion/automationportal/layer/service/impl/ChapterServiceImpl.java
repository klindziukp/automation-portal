package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.layer.repository.ChaptersRepository.ChapterSelfCheckProjection;
import com.dandelion.automationportal.layer.service.ChapterJpaService;
import com.dandelion.automationportal.model.chapter.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterJpaService {

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
    public List<ChapterSelfCheckProjection> findAllSelfCheckQuestionsByChapterName(String chapterName) {
        return chaptersJpaRepository.findAllSelfCheckQuestionsByChapterName(chapterName);
    }
}
