package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.layer.repository.mongo.ProgramMongoRepository;
import com.dandelion.automationportal.layer.repository.ProgramRepository;
import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.model.Topic;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProgramServiceImpl implements ProgramService {

    private static final String DEFAULT_PROGRAM_NAME = "Automation";

    private ChaptersRepository chaptersRepository;
    private ProgramRepository programRepository;
    private TopicsRepository topicsRepository;

    @Autowired
    public ProgramServiceImpl(ChaptersRepository chaptersRepository, TopicsRepository topicsRepository,
                              ProgramMongoRepository programMongoRepository) {
        this.chaptersRepository = chaptersRepository;
        this.topicsRepository = topicsRepository;
        this.programRepository = programMongoRepository;
    }

    @Override
    public List<Program> findAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Program findProgramByName(String programName) {
        Program program = Objects.requireNonNull(programRepository.findByName(programName));
        program.setChapters(getChapters(program));
        program.setTopics(getTopics(program));
        return program;
    }

    @NotNull
    private List<Topic> getTopics(Program program) {
        List<Topic> topics = new ArrayList<>();
        program.getSequence().forEach(key -> topics.addAll(topicsRepository.findAllTopicsByKey(key)));
        return topics;
    }

    @NotNull
    private List<Chapter> getChapters(Program program) {
        List<Chapter> chapters = new ArrayList<>();
        program.getSequence().forEach(key -> chapters.addAll(chaptersRepository.findAllChaptersByKey(key)));
        return chapters;
    }

    @Override
    public Program getDefaultProgram() {
        return findProgramByName(DEFAULT_PROGRAM_NAME);
    }
}
