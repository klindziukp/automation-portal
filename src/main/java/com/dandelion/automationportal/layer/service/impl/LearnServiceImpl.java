package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.layer.repository.QuestionsRepository;
import com.dandelion.automationportal.layer.repository.mongo.ChaptersMongoRepository;
import com.dandelion.automationportal.layer.repository.mongo.QuestionsMongoRepository;
import com.dandelion.automationportal.layer.service.LearnService;
import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import com.dandelion.automationportal.support.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnServiceImpl implements LearnService {

    private ChaptersRepository chaptersRepository;
    private QuestionsRepository questionsRepository;

    @Autowired
    public LearnServiceImpl(ChaptersMongoRepository chaptersMongoRepository,
                            QuestionsMongoRepository questionsMongoRepository) {
        this.chaptersRepository = chaptersMongoRepository;
        this.questionsRepository = questionsMongoRepository;
    }

    @Override
    public List<SelfCheckQuestion> findAllByChapterKey(String chapterKey) {
        return questionsRepository.findAllByChapterKey(chapterKey);
    }

    @Override
    public Chapter findFirstChapterByKey(String chapterKey) {
        return chaptersRepository.findFirstChapterByKey(chapterKey);
    }

    @Override
    public String getChapterNameFromKey(String chapterKey) {
        return String.join(" ", StringUtil.splitByUpperCase(chapterKey)).toUpperCase();
    }
}
