package com.myapp.pengeluaranku.service.auth.impl;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.service.auth.AuthService;
import com.myapp.pengeluaranku.util.Constants;
import com.myapp.pengeluaranku.vo.TokenVO;
import com.myapp.pengeluaranku.vo.keycloak.RefreshTokenReqVO;

import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class RefreshTokenService implements AuthService {
    private static final Logger log = LoggerFactory.getLogger(RefreshTokenService.class);
    @Value("${keycloak.auth-server-url}")
    String keycloakServer;

    @Value("${keycloak.resource}")
    String clientId;

    @Value("${keycloak.credentials.secret}")
    String clientSecret;

    @Value("${keycloak.realm}")
    String realm;
    @Override
    public TokenVO refreshToken(RefreshTokenReqVO vo){
        // 1. set uri
        String uri = keycloakServer + String.format(Constants.Keycloak.TOKEN_URI, realm);
        TokenVO tokenVO = new TokenVO();
        // 3. set request payload
        
        // Refresh Token using REST API
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // set form data
        MultiValueMap<String, String> getRefreshTokenMap = new LinkedMultiValueMap<>();
        getRefreshTokenMap.add("grant_type", "refresh_token");
        getRefreshTokenMap.add("refresh_token", vo.getRefreshToken());
        getRefreshTokenMap.add("client_id", clientId);
        getRefreshTokenMap.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> refreshToken = new HttpEntity<>(getRefreshTokenMap, headers);
        // 4. REST API
        RestTemplate restTemplateToken = new RestTemplate();
        try {
            ResponseEntity<AccessTokenResponse> response = restTemplateToken.postForEntity(uri, refreshToken,
                    AccessTokenResponse.class);

            // good true
            if (response.getStatusCode() == HttpStatus.OK) {
                tokenVO.setToken(response.getBody().getToken());
                tokenVO.setRefreshToken(response.getBody().getRefreshToken());
            }

            // bad result
            if (response.getStatusCode() == HttpStatus.BAD_REQUEST) throw new PengeluarankuException("BAD REQUEST", HttpStatus.BAD_REQUEST, StatusCode.BAD_REQUEST);
        } catch(RestClientException e) {
            log.error("ERROR: ", e);
            throw new PengeluarankuException("Error keycloak Server", HttpStatus.INTERNAL_SERVER_ERROR, StatusCode.ERROR);
        }
        // 5. return value
        return tokenVO;
    }
}