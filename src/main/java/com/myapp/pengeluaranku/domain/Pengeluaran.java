package com.myapp.pengeluaranku.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

import lombok.Data;

@Entity
@Table(name="PENGELUARAN")
@Data
@DynamicUpdate
public class Pengeluaran extends Base{

    @Column(name="NAME", nullable = false, unique = true)
    private String name;

    @Column(name="TYPE", nullable = false)
    private String type;

    @Column(name="CODE", nullable = true)
    private String code;
}