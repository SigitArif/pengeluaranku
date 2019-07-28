package com.myapp.pengeluaranku.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Data
public abstract class Base implements Serializable{
    @Id
    @Column(name="UUID", unique = true, length = 36, nullable=false)
    private String uuid;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATED", updatable = false, nullable = false)
    private Date creationDate;

    @CreatedBy
    @Column(name = "CREATED_BY", length = 50, updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_MODIFIED")
    private Date modificationDate;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY", length = 50)
    private String modifiedBy;
    
    @PrePersist
    public void prePersist(){
        this.uuid = UUID.randomUUID().toString();
        this.creationDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.modificationDate = new Date();
    }
}