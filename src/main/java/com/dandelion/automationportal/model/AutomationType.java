package com.dandelion.automationportal.model;

import com.dandelion.automationportal.model.chapter.Chapter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "automation_type")
@Data
public class AutomationType {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    @JsonProperty("id")
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "automationType", fetch = FetchType.LAZY)
    @JsonProperty("chapters")
    @JsonManagedReference
    private List<Chapter> chapters;
}
