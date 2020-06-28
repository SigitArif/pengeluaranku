package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginVO {
    private String id;
    private String password;
    @JsonProperty("status_login")
    private String statusLogin;
}