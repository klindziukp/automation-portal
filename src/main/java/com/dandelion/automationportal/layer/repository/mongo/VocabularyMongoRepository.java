package com.dandelion.automationportal.layer.repository.mongo;

import com.dandelion.automationportal.layer.repository.VocabularyRepository;
import com.dandelion.automationportal.model.VocabularyItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyMongoRepository extends MongoRepository<VocabularyItem, String>, VocabularyRepository {

}
