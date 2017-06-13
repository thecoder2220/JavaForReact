package com.claurier.common.commons.entities;

import com.claurier.common.commons.persistence.IdGenerator;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public class BaseEntity {
    @Id
    private Long id;

    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = IdGenerator.generate();
        }
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

