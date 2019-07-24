package com.dandelion.automationportal.model.chapter;

import com.dandelion.automationportal.model.UpdatableEntity;
import com.dandelion.automationportal.model.AutomationType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
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
@ToString(exclude = { "automationType", "links", "notes", "questions", "selfCheckQuestions", "tasks" })
@JsonIgnoreProperties({ "id", "createdAt", "updatedAt", "deletedAt", "createdBy", "updatedBy", "deletedBy" })
public class Chapter extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_id", nullable = false)
    @JsonBackReference
    private AutomationType automationType;

    @Column(name = "automation_name")
    @JsonProperty("automationName")
    private String automationName;

    @Column(name = "name")
    @JsonProperty("chapterName")
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

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty("selfCheckQuestions")
    private List<SelfCheckQuestion> selfCheckQuestions;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("tasks")
    private List<Task> tasks;
}
