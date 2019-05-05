package com.dandelion.automationportal.layer.repository.mongo;

import com.dandelion.automationportal.layer.repository.QuestionsRepository;
import com.dandelion.automationportal.model.SelfCheckQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsMongoRepository extends MongoRepository<SelfCheckQuestion, String>, QuestionsRepository {

}
