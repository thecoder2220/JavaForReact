package com.claurier.user.modules.user.model;

import com.claurier.common.commons.entities.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="is_function")
public class Function
extends BaseEntity {
    @Column(name="code", nullable=false, length=255)
    private String code;
    @Column(name="date_creation", nullable=false)
    private LocalDateTime dateCreation;
    @Column(name="type", length=20)
    private String type;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

