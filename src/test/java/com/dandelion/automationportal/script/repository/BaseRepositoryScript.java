package com.dandelion.automationportal.script.repository;

import com.dandelion.automationportal.support.JpaVerificationService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class BaseRepositoryScript {

    protected JpaVerificationService jpaVerificationService = new JpaVerificationService();
}