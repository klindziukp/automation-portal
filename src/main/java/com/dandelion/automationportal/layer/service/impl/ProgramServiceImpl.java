package com.dandelion.automationportal.layer.service.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.layer.repository.mongo.ProgramMongoRepository;
import com.dandelion.automationportal.layer.repository.ProgramRepository;
import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProgramServiceImpl implements ProgramService {

    private static final String DEFAULT_PROGRAM_NAME = "Automation";

    private ChaptersRepository chaptersRepository;
    private ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ChaptersRepository chaptersRepository, ProgramMongoRepository programMongoRepository) {
        this.chaptersRepository = chaptersRepository;
        this.programRepository = programMongoRepository;
    }

    @Override
    public List<Program> findAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Program findProgramByName(String programName) {
        Program program = Objects.requireNonNull(programRepository.findByName(programName));
        program.setChapters(chaptersRepository.findAll());
        return program;
    }

    @Override
    public Program getDefaultProgram() {
        return findProgramByName(DEFAULT_PROGRAM_NAME);
    }
}
