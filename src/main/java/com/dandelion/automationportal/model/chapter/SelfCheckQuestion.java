package com.dandelion.automationportal.model.chapter;

import com.dandelion.automationportal.model.UpdatableEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.Table;

@Entity
@Table(name = "self_check_question")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "chapter")
@JsonIgnoreProperties({ "id", "createdAt", "updatedAt", "deletedAt", "createdBy", "updatedBy", "deletedBy" })
public class SelfCheckQuestion extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
