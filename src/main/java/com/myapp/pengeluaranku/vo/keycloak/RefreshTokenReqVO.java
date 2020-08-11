package com.myapp.pengeluaranku.vo.keycloak;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RefreshTokenReqVO {
    @JsonProperty("refresh_token")
    @NotBlank(message = "Refresh token can't be empty")
    private String refreshToken;

}