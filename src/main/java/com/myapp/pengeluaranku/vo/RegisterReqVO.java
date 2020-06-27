package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class RegisterReqVO {
    private String password;
    private UserReqVO user;
}