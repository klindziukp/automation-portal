package com.dandelion.automationportal.model.topic;

import com.dandelion.automationportal.model.UpdatableEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
@ToString(exclude = "automationTopic")
@JsonIgnoreProperties({ "id", "createdAt", "updatedAt", "deletedAt", "createdBy", "updatedBy", "deletedBy" })
public class AutomationTopicChapter extends UpdatableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "automation_topic_id", nullable = false)
    private AutomationTopic automationTopic;

    @Column(name = "automationTopicName")
    @JsonProperty("automationTopicName")
    private String automationTopicName;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "key_word")
    @JsonProperty("key")
    private String key;

    @Column(name = "begin_with")
    @JsonProperty("beginWith")
    private String beginWith;

    @Column(name = "text")
    @JsonProperty("text")
    private String text;
}
