package com.dandelion.automationportal.model.chapter;

import com.dandelion.automationportal.model.UpdatableEntity;
import com.dandelion.automationportal.model.AutomationType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "chapter")
@Data
@EqualsAndHashCode(callSuper = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Chapter extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_id", nullable = false)
    @JsonBackReference
    private AutomationType automationType;

    @Column(name = "automation_name")
    @JsonProperty("automation_name")
    private String automationName;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "general_info")
    @JsonProperty("generalInfo")
    private String generalInfo;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("links")
    private List<Link> links;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("notes")
    private List<Note> notes;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("questions")
    private List<Question> questions;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("selfCheckQuestions")
    private List<SelfCheckQuestion> selfCheckQuestions;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("tasks")
    private List<Task> tasks;
}
