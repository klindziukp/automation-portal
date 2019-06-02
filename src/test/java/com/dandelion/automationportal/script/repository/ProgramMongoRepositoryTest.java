package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.layer.repository.mongo.ProgramMongoRepository;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.support.DatabaseEntity;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.data.TestDataStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_METHOD)
class ProgramMongoRepositoryTest extends BaseMongoRepositoryScript {

    private ProgramMongoRepository programMongoRepository;
    private DatabaseEntity databaseEntity;

    @Autowired
    public ProgramMongoRepositoryTest(ProgramMongoRepository programMongoRepository, DatabaseEntity databaseEntity) {
        this.programMongoRepository = programMongoRepository;
        this.databaseEntity = databaseEntity;
    }

    @BeforeEach
    void initDatabase() {
        initDatabase(databaseEntity);
    }

    @Test()
    void findProgramTest() {

        GIVEN();
        Program expected = JsonTestDataStorage.getPrograms().get(0);

        WHEN();
        Program actual = programMongoRepository.findByName(expected.getName());

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected,"id");
    }

    @Test()
    void findAllProgramsTest() {

        GIVEN();
        List<Program> expectedPrograms = JsonTestDataStorage.getPrograms();

        WHEN();
        List<Program> actualPrograms = programMongoRepository.findAll();

        THEN();
        assertThat(expectedPrograms).usingElementComparatorIgnoringFields("id").isEqualTo(actualPrograms);
    }

    @Test()
    void insertProgramTest() {

        GIVEN();
        Program testProgram = TestDataStorage.getTestProgram();

        WHEN();
        programMongoRepository.insert(testProgram);
        List<Program> programs = programMongoRepository.findAll();

        THEN();
        assertThat(programs).contains(testProgram);
    }

    @Test()
    void deleteProgramTest() {

        GIVEN();
        Program programToDelete = programMongoRepository.findAll().get(0);
        List<Program> listBeforeDelete = programMongoRepository.findAll();
        assertThat(listBeforeDelete).contains(programToDelete);

        WHEN();
        programMongoRepository.delete(programToDelete);
        List<Program> listAfterDelete = programMongoRepository.findAll();

        THEN();
        assertThat(listAfterDelete).isNotEqualTo(listBeforeDelete);
        assertThat(listAfterDelete).doesNotContain(programToDelete);
    }
}
