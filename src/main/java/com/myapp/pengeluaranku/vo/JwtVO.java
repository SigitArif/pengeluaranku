package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class JwtVO {
    private String jti;
    private Integer exp;
    private Integer nbf;
    private Integer iat;
    private String iss;
    private String aud;
    private String sub;
    private String typ;
    private String azp;
    private Integer auth_time;
    private String session_state;
    private String acr;
    private String client_session;
    private String[] allowed_origins;
    private RealmAccessVO realm_access;
    private ResourceAccessVO resource_access;
    private String name;
    private String preferred_username;
    private String given_name;
    private String family_name;
    private String email;
}