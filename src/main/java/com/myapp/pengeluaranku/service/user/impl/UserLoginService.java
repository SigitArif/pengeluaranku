package com.myapp.pengeluaranku.service.user.impl;

import com.myapp.pengeluaranku.config.KeycloakAdminClient;
import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.*;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.user.UserService;
import com.myapp.pengeluaranku.validator.UserValidator;
import com.myapp.pengeluaranku.vo.*;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserLoginService.class);
    @Autowired
    UserValidator userValidator;
    @Autowired
    UserRepository userRepository;
    @Autowired
    KeycloakAdminClient keycloakAdmin;
    @Override
    public AuthResponseVO login(LoginVO vo){
        // validate login request
        userValidator.validateLogin(vo);

        String statusLogin = vo.getStatusLogin();
        log.info("STATUS_LOGIN: ", statusLogin);
        String username = vo.getId();
        log.info("USERNAME: ", username);
        String password = vo.getPassword();
        log.info("PASSWORD: ", password);

        Keycloak keycloak = null;

        if(statusLogin.equals(StatusLogin.EMAIL)){
            //1. check user exist
            User user = userRepository.findByEmail(username);
            if(user==null) throw new PengeluarankuException("User Not Found", HttpStatus.NOT_FOUND, StatusCode.DATA_NOT_FOUND);
            //2. login keycloak
            keycloak = keycloakAdmin.doLogin(username, password);
        }

        //3. get token

        AccessTokenResponse accessTokenResponse = keycloakAdmin.getToken(keycloak);
        //4. set token
        AuthResponseVO authResponseVO = AuthResponseVO.builder().build();

        authResponseVO.setToken(accessTokenResponse.getToken());
        authResponseVO.setRefreshToken(accessTokenResponse.getRefreshToken());
        // close keycloak
        keycloak.close();
        
        return authResponseVO;
    }


}