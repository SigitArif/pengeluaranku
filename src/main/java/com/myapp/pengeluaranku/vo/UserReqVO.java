package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class UserReqVO{
    
    private String name;
    private String address;
    private String phone;
    private String email;
    public UserReqVO(){};

}