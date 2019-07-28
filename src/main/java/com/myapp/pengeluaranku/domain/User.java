package com.myapp.pengeluaranku.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
@Entity
@Table(name="USER")
@Data
@DynamicUpdate
public class User extends Base{
    
    @Column(name="NAME", nullable = false)
    private String name;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="PHONE")
    private String phone;
    @Column(name="EMAIL")
    private String email;

    
}