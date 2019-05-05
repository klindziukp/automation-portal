package com.dandelion.automationportal.layer.repository.mongo;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersMongoRepository extends MongoRepository<Chapter, String>, ChaptersRepository {

}
