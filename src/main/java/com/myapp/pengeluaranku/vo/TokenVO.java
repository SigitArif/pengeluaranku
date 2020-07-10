package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
public class TokenVO {

    private String token;
    
    @JsonProperty("refresh_token")
    private String refreshToken;
}