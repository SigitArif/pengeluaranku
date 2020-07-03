package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseVO extends TokenVO {
    @JsonProperty("full_name")
    private String fullName;

    private String[] role;
}