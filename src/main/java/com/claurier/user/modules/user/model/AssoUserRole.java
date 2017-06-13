package com.claurier.user.modules.user.model;

import com.claurier.common.commons.entities.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="is_asso_user_role")
public class AssoUserRole
extends BaseEntity {
    @Column(name="id_user", nullable=false)
    private Long idUser;
    @Column(name="id_role", nullable=false)
    private Long idRole;

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdRole() {
        return this.idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
}

