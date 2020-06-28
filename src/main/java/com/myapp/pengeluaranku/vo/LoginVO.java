package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginVO {
    private String id;
    private String password;
    @JsonProperty("status_login")
    private String statusLogin;
}