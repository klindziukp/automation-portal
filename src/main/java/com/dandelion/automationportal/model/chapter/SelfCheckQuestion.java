package com.dandelion.automationportal.model.chapter;

import com.dandelion.automationportal.model.UpdatableEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
@Data
@EqualsAndHashCode(callSuper = true)
public class SelfCheckQuestion extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id", nullable = false)
    @JsonBackReference
    private Chapter chapter;

    @Column(name = "chapter_name")
    @JsonProperty("chapterName")
    private String chapterName;

    @Column(name = "question")
    @JsonProperty("question")
    private String question;

    @Column(name = "answer")
    @JsonProperty("answer")
    private String answer;
}
