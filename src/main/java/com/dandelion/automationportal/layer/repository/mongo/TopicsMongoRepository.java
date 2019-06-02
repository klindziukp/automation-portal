package com.dandelion.automationportal.layer.repository.mongo;

import com.dandelion.automationportal.layer.repository.TopicsRepository;
import com.dandelion.automationportal.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsMongoRepository extends MongoRepository<Topic, String>, TopicsRepository {

}
