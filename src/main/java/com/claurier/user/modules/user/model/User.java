package com.claurier.user.modules.user.model;

import com.claurier.common.commons.entities.IHistory;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User
implements IHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    @Column(name="lastname", nullable=false)
    private String lastname;
    @Column(name="firstname", nullable=false)
    private String firstname;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="login", nullable=false, unique=true)
    private String login;
    @Column(name="password_hash", nullable=false)
    private String passwordHash;
    @Column(name="phone_number", length=20)
    private String phoneNumber;
    @Column(name="company")
    private String company;
    @Column(name="disabled")
    private boolean disabled;
    @JoinTable(name="asso_user_group", joinColumns={@JoinColumn(name="id_user", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="id_group", referencedColumnName="id")})
    @ManyToMany
    private Set<Group> groups;
    @Column(name="id_user_crea")
    private Long idUserCreation;
    @Column(name="id_user_mod")
    private Long idUserModification;
    @Column(name="date_creation", nullable=false)
    private LocalDateTime dateCreation;
    @Column(name="date_modification")
    private LocalDateTime dateModification;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Long getIdUserCreation() {
        return this.idUserCreation;
    }

    public void setIdUserCreation(Long idUserCreation) {
        this.idUserCreation = idUserCreation;
    }

    public Long getIdUserModification() {
        return this.idUserModification;
    }

    public void setIdUserModification(Long idUserModification) {
        this.idUserModification = idUserModification;
    }

    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateModification() {
        return this.dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }

    @Deprecated
    public boolean isDisable() {
        return this.isDisabled();
    }

    @Deprecated
    public void setDisable(boolean disable) {
        this.setDisabled(disable);
    }
}

