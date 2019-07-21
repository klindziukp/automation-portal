package com.dandelion.automationportal.layer.repository.jpa.impl;

import com.dandelion.automationportal.layer.repository.jpa.ChaptersRepository;
import com.dandelion.automationportal.model.jpa.chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersJpaRepository extends JpaRepository<Chapter, Long>, ChaptersRepository {

}
