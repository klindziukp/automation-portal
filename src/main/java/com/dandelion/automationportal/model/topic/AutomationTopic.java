package com.dandelion.automationportal.model.topic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "automation_topic")
@Data
@ToString(exclude = "topicChapters")
@JsonIgnoreProperties({ "id" })
public class AutomationTopic {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "automationTopic", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("topicChapters")
    private List<AutomationTopicChapter> topicChapters;
}
