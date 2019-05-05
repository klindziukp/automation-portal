package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.Program;

import java.util.List;

public interface ProgramService {

    List<Program> findAllPrograms();
    Program findProgramByName(String programName);
    Program getDefaultProgram();
}
