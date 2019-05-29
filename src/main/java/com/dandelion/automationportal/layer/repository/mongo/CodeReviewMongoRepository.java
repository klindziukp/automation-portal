package com.dandelion.automationportal.layer.repository.mongo;

import com.dandelion.automationportal.layer.repository.CodeReviewRepository;
import com.dandelion.automationportal.model.CodeReviewItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeReviewMongoRepository extends MongoRepository<CodeReviewItem, String>, CodeReviewRepository {

}
