package com.dandelion.automationportal.layer.repository.mongo;

import com.dandelion.automationportal.layer.repository.ProgramRepository;
import com.dandelion.automationportal.model.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramMongoRepository extends MongoRepository<Program, String>, ProgramRepository {

}
