package com.dandelion.automationportal.model.jpa.chapter;

import com.dandelion.automationportal.model.jpa.AutomationType;
import com.dandelion.automationportal.model.jpa.UpdatableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Chapter extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_id", nullable = false)
    private AutomationType automationType;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "general_info")
    private String generalInfo;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<Link> links;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<Note> notes;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<SelfCheckQuestion> selfCheckQuestions;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<Task> tasks;
}
