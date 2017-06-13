package com.claurier.user.modules.user.model;

import com.claurier.common.commons.entities.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="is_url")
public class Url
extends BaseEntity {
    @Column(name="url", nullable=false, length=255)
    private String url;
    @Column(name="code_langue", length=2)
    private String codeLangue;
    @Column(name="id_function", nullable=false)
    private Long idFunction;
    @Column(name="date_creation", nullable=false)
    private LocalDateTime dateCreation;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCodeLangue() {
        return this.codeLangue;
    }

    public void setCodeLangue(String codeLangue) {
        this.codeLangue = codeLangue;
    }

    public Long getIdFunction() {
        return this.idFunction;
    }

    public void setIdFunction(Long idFunction) {
        this.idFunction = idFunction;
    }

    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}

