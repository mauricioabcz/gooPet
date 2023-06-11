package com.gooPet.Auth.Database.Entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mauricio.rodrigues
 */
@Entity
@Table(name = "[auth].[UserType]")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Descricao")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "InsertDate")
    private Date insertDate;

    // construtores, getters e setters

    public UserType() {
        // construtor vazio necessário para o Hibernate
    }
    
    public UserType(String nome, String descricao, Date insertDate) {
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "UserType{" + "nome=" + nome + ", descricao=" + descricao + '}';
    }
    
}