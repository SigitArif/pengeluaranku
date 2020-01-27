package com.myapp.pengeluaranku.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Table(name="USER")
@Data
@DynamicUpdate
@Entity
public class User extends Base{

    @Column(name="NAME")
    private String name;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="PHONE")
    private String phone;
    @Column(name="EMAIL")
    private String email;

}