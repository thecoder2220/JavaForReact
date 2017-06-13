package com.claurier.user.modules.user.model;

import com.claurier.common.commons.entities.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="is_asso_function_role")
public class AssoFunctionRole
extends BaseEntity {
    @Column(name="id_function", nullable=false)
    private Long idFunction;
    @Column(name="id_role", nullable=false)
    private Long idRole;

    public Long getIdFunction() {
        return this.idFunction;
    }

    public void setIdFunction(Long idFunction) {
        this.idFunction = idFunction;
    }

    public Long getIdRole() {
        return this.idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
}

