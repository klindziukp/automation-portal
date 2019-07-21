package com.dandelion.automationportal.model.jpa;

import com.dandelion.automationportal.model.jpa.chapter.Chapter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "automation_type")
@Data
public class AutomationType {

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "automation_topic", fetch = FetchType.LAZY)
    private List<Chapter> chapters;
}
