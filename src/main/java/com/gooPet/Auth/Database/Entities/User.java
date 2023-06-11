package com.gooPet.Auth.Database.Entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mauricio.rodrigues
 */
@Entity
@Table(name = "[auth].[User]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    
    @Column(name = "Nome")
    private String nome;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "PasswordHash", columnDefinition = "varchar(max)")
    private String passwordHash;
    
    @ManyToOne
    @JoinColumn(name = "UserTypeId")
    private UserType userType;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "InsertDate")
    private Date insertDate;

    // construtores, getters e setters

    public User() {
        // construtor vazio necessário para o Hibernate
    }

    public User(String nome, String email, String passwordHash, UserType userType, Date insertDate) {
        this.nome = nome;
        this.email = email;
        this.passwordHash = passwordHash;
        this.userType = userType;
        this.insertDate = insertDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UUID getUserTypeId() {
        return userType.getId();
    }

    public void setUserTypeId(UserType userType) {
        this.userType.setId(userType.getId());
    }
    
    public UserType getUserType() {
        return userType;
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "User{" + "nome=" + nome + ", email=" + email + ", userType=" + userType.getNome() + '}';
    }
    
}