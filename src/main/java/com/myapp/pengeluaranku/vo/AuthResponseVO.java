package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthResponseVO {
    @JsonProperty("full_name")
    private String fullName;

    private String[] role;
}