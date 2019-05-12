package com.dandelion.automationportal.script.service;

import com.dandelion.automationportal.layer.service.ProgramService;
import com.dandelion.automationportal.model.Program;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;
@ComponentScan("com.dandelion.automationportal")
class ProgramServiceTest extends BaseServiceTest {

    private ProgramService programService;

    @Autowired
    public ProgramServiceTest(ProgramService programService) {
        this.programService = programService;
    }

    @BeforeAll
    static void initEmbeddedService() {
        initEmbeddedService("program");
    }

    @Test()
    void findProgramTest() {

        GIVEN();
        Program expected = JsonTestDataStorage.getPrograms().get(0);

        WHEN();
        Program actual = programService.findProgramByName(expected.getName());

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "id", "chapters");
    }

    @Test()
    void findAllProgramsTest() {

        GIVEN();
        List<Program> expectedPrograms = JsonTestDataStorage.getPrograms();

        WHEN();
        List<Program> actualPrograms = programService.findAllPrograms();
        System.out.println(actualPrograms);

        THEN();
        assertThat(expectedPrograms).usingElementComparatorIgnoringFields("id").isEqualTo(actualPrograms);
    }
}
