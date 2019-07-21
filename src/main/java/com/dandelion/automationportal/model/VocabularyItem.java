package com.dandelion.automationportal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vocabulary")
@Data
@EqualsAndHashCode(callSuper = true)
public class VocabularyItem extends UpdatableEntity {

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;
}
