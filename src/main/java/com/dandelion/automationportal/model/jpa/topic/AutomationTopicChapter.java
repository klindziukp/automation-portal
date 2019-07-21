package com.dandelion.automationportal.model.jpa.topic;

import com.dandelion.automationportal.model.jpa.UpdatableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "automation_topic_chapter")
@Data
@EqualsAndHashCode(callSuper = true)
public class AutomationTopicChapter extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_topic_id", nullable = false)
    private AutomationTopic automationTopic;

    @Column(name = "name")
    private String name;

    @Column(name = "begin_with")
    private String beginWith;

    @Column(name = "text")
    private String text;
}
