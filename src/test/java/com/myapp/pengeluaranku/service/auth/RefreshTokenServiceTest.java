package com.myapp.pengeluaranku.service.auth;

import static org.junit.Assert.assertNotNull;

import com.myapp.pengeluaranku.service.auth.impl.RefreshTokenService;
import com.myapp.pengeluaranku.vo.TokenVO;
import com.myapp.pengeluaranku.vo.keycloak.RefreshTokenReqVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RefreshTokenServiceTest {
    @Autowired
    RefreshTokenService refreshTokenService;
    @Test
    public void refreshTokenThenOK(){
        RefreshTokenReqVO vo = new RefreshTokenReqVO();
        String refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJmZWVjYmRhYS00ZDIxLTRlMmQtYjE3NS1jMzgzYjUyMjlmNjkifQ.eyJleHAiOjE1OTcxMTUxMDUsImlhdCI6MTU5NzExMzMwNSwianRpIjoiMWFkMDQzNjUtOWNjYy00ZDVjLWE0NWYtZmFkZWU5MTcyZTdiIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL3BlbmdlbHVhcmFua3UiLCJhdWQiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvcGVuZ2VsdWFyYW5rdSIsInN1YiI6ImRiMGNhYTE2LTRkN2EtNGI1ZS04MzMxLTM1MTg4N2QxMjY1ZSIsInR5cCI6IlJlZnJlc2giLCJhenAiOiJhcGktcGVuZ2VsdWFyYW5rdSIsInNlc3Npb25fc3RhdGUiOiJmNjNhYmIwYy03ODQzLTQyZDItODlkMC0xODFkYzI1NDEyZGUiLCJzY29wZSI6InByb2ZpbGUgZW1haWwifQ.9cwz6JGuSmoFrePRjwCMQqXx-a_e_GoPm81SQLdOBJg";
        vo.setRefreshToken(refreshToken);
        TokenVO actual = refreshTokenService.refreshToken(vo);
        assertNotNull(actual);
    }
}