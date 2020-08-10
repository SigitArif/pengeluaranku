package com.myapp.pengeluaranku.vo.keycloak;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RefreshTokenReqVO {
    @JsonProperty("refresh_token")
    private String refreshToken;
}