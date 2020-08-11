package com.myapp.pengeluaranku.service.auth;

import com.myapp.pengeluaranku.vo.TokenVO;
import com.myapp.pengeluaranku.vo.keycloak.RefreshTokenReqVO;

public interface AuthService {
    default public TokenVO refreshToken(RefreshTokenReqVO vo){
        return null;
    }
}