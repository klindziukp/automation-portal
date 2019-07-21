package com.dandelion.automationportal.model.topic;

import com.dandelion.automationportal.model.UpdatableEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "automation_topic_chapter")
@Data
@EqualsAndHashCode(callSuper = true)
public class AutomationTopicChapter extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "automation_topic_id", nullable = false)
    private AutomationTopic automationTopic;

    @Column(name = "name")
    private String name;

    @Column(name = "begin_with")
    private String beginWith;

    @Column(name = "text")
    private String text;
}
