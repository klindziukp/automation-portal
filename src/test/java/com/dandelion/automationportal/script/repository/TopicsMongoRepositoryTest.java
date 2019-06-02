package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.layer.repository.mongo.TopicsMongoRepository;
import com.dandelion.automationportal.model.Topic;
import com.dandelion.automationportal.support.DatabaseEntity;
import com.dandelion.automationportal.support.data.JsonTestDataStorage;
import com.dandelion.automationportal.support.data.TestDataStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static com.dandelion.automationportal.support.Step.GIVEN;
import static com.dandelion.automationportal.support.Step.THEN;
import static com.dandelion.automationportal.support.Step.WHEN;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_METHOD)
class TopicsMongoRepositoryTest extends BaseMongoRepositoryTest {

    private TopicsMongoRepository topicsMongoRepository;
    private DatabaseEntity databaseEntity;

    @Autowired
    public TopicsMongoRepositoryTest(TopicsMongoRepository topicsMongoRepository, DatabaseEntity databaseEntity) {
        this.topicsMongoRepository = topicsMongoRepository;
        this.databaseEntity = databaseEntity;
    }

    @BeforeEach
    void initDatabase() {
        initDatabase(databaseEntity);
    }

    @Test()
    void findAllChaptersTest() {

        GIVEN();
        List<Topic> expected = JsonTestDataStorage.getTopics();

        WHEN();
        List<Topic> actual = topicsMongoRepository.findAll();

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test()
    void findAllTopicsByKeyTest() {

        GIVEN();
        List<Topic> allTopics = JsonTestDataStorage.getTopics();
        String expectedKey = JsonTestDataStorage.getTopics().get(0).getKey();
        List<Topic> expected = allTopics.stream().filter(topic -> topic.getKey().equals(expectedKey)).collect(Collectors.toList());

        WHEN();
        List<Topic> actual = topicsMongoRepository.findAllTopicsByKey(expectedKey);

        THEN();
        assertThat(expected).usingElementComparatorIgnoringFields("id").isEqualTo(actual);
    }

    @Test
    void findByKeyTest() {

        GIVEN();
        Topic expected = JsonTestDataStorage.getTopics().get(0);
        String chapterKey = expected.getKey();

        WHEN();
        Topic actual = topicsMongoRepository.findFirstTopicByKey(chapterKey);

        THEN();
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "id");
    }

    @Test
    void insertChapterTest() {

        GIVEN();
        Topic testTopic = TestDataStorage.getTestTopic();

        WHEN();
        topicsMongoRepository.insert(testTopic);
        List<Topic> after = topicsMongoRepository.findAll();

        THEN();
        assertThat(after).contains(testTopic);
    }

    @Test
    void deleteChapterTest() {

        GIVEN();
        Topic testChapter = topicsMongoRepository.findAll().get(0);
        List<Topic> listBeforeDelete = topicsMongoRepository.findAll();

        WHEN();
        topicsMongoRepository.delete(testChapter);
        List<Topic> listAfterDelete = topicsMongoRepository.findAll();

        THEN();
        assertThat(listAfterDelete).isNotEqualTo(listBeforeDelete);
        assertThat(listAfterDelete).doesNotContain(testChapter);
    }

    @Test
    void deleteAllTopicsTest() {

        GIVEN();
        topicsMongoRepository.deleteAll();

        WHEN();
        int chapterQuantity = topicsMongoRepository.findAll().size();

        THEN();
        assertThat(chapterQuantity).isEqualTo(0);
    }
}
