package com.claurier.user.modules.user.lightbeans;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDateTime;

public class UrlLightBean {
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;
    private String url;
    private String codeLangue;
    @JsonSerialize(using=ToStringSerializer.class)
    private Long idFunction;
    private LocalDateTime dateCreation;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

