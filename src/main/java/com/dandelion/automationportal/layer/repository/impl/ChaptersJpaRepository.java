package com.dandelion.automationportal.layer.repository.impl;

import com.dandelion.automationportal.layer.repository.ChaptersRepository;
import com.dandelion.automationportal.model.chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersJpaRepository extends JpaRepository<Chapter, Long>, ChaptersRepository {

}
