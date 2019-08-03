package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vocabulary")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({ "id", "createdAt", "updatedAt", "deletedAt", "createdBy", "updatedBy", "deletedBy" })
public class VocabularyItem extends UpdatableEntity {

    @Column(name = "key_word")
    private String key;

    @Column(name = "value")
    private String value;
}
