package com.myapp.pengeluaranku.controller;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.service.auth.impl.RefreshTokenService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.ResultVO;
import com.myapp.pengeluaranku.vo.TokenVO;
import com.myapp.pengeluaranku.vo.keycloak.RefreshTokenReqVO;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/auth")
public class AuthController {

    @Autowired
    RefreshTokenService refreshTokenService;
   
    @PostMapping(value = "refresh-token")
    @ResponseBody
    public ResponseEntity<ResultVO> refreshToken(@RequestBody RefreshTokenReqVO vo) {
        ResultVO result = new ResultVO();
        TokenVO results = refreshTokenService.refreshToken(vo);
        result.setStatus(HttpStatus.SC_OK);
        result.setMessage("Refresh Token Success");
        result.setResults(results);

        return RestUtil.getJsonResponse(result);
    }
    
}