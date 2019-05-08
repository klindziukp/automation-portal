package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.layer.repository.mongo.ChaptersMongoRepository;
import com.dandelion.automationportal.model.Chapter;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.data.TestDataStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

class ChaptersMongoRepositoryTest extends BaseMongoRepositoryTest {

    ChaptersMongoRepository chaptersMongoRepository;

    @Autowired
    public ChaptersMongoRepositoryTest(ChaptersMongoRepository chaptersMongoRepository) {
        this.chaptersMongoRepository = chaptersMongoRepository;
    }

    @BeforeAll
    static void initEmbeddedService(){
        initEmbeddedService("chapters");
    }

    @Test()
    void findAllChaptersTest() {

        GIVEN();
        List<Chapter> expected = JsonTestDataStorage.getChapters();

        WHEN();
        List<Chapter> actual = chaptersMongoRepository.findAll();

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test
    void findByKeyTest() {

        GIVEN();
        Chapter expected = JsonTestDataStorage.getChapters().get(0);
        String chapterKey = expected.getKey();

        WHEN();
        Chapter actual = chaptersMongoRepository.findFirstChapterByKey(chapterKey);

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "id");
    }

    @Test
    void insertChapterTest() {

        GIVEN();
        Chapter testChapter = TestDataStorage.getTestChapter();

        WHEN();
        chaptersMongoRepository.insert(testChapter);
        List<Chapter> after = chaptersMongoRepository.findAll();

        THEN();
        assertThat(after).contains(testChapter);
    }

    @Test
    void deleteChapterTest() {

        GIVEN();
        Chapter testChapter = chaptersMongoRepository.findAll().get(0);
        List<Chapter> listBeforeDelete = chaptersMongoRepository.findAll();

        WHEN();
        chaptersMongoRepository.delete(testChapter);
        List<Chapter> listAfterDelete = chaptersMongoRepository.findAll();

        THEN();
        assertThat(listAfterDelete).isNotEqualTo(listBeforeDelete);
        assertThat(listAfterDelete).doesNotContain(testChapter);
    }

    @Test
    void deleteAllChapterTest() {

        GIVEN();
        chaptersMongoRepository.deleteAll();

        WHEN();
        int chapterQuantity = chaptersMongoRepository.findAll().size();

        THEN();
        assertThat(chapterQuantity).isEqualTo(0);
    }
}
