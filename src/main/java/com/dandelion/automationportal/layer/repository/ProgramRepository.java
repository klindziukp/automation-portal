package com.dandelion.automationportal.layer.repository;

import com.dandelion.automationportal.model.Program;

import java.util.List;

public interface ProgramRepository {

    List<Program> findAll();
    Program findByName(String name);
}
