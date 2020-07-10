package com.myapp.pengeluaranku.config;

import javax.ws.rs.NotAuthorizedException;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.util.Constants;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
public class KeycloakAdminClient {

    private static final Logger log = LoggerFactory.getLogger(KeycloakAdminClient.class);
    
    @Value("${keycloak.auth-server-url}")
    private String keycloakServer;

    @Value("${admin.keycloak.username}")
    private String usernameAdmin;
    
    @Value("${admin.keycloak.password}")
    private String passwordAdmin;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    String clientId;

    @Value("${keycloak.credentials.secret}")
    String clientSecret;
    
    private Keycloak keycloak;
    
    public Keycloak getInstance(){
        System.out.println(keycloak);
        if(keycloak!=null){
            return keycloak;
        }
        else{
            Keycloak keycloakAdmin;
    
        try{
            keycloakAdmin = Keycloak.getInstance(keycloakServer, 
            Constants.Keycloak.REALM_MASTER, 
            usernameAdmin, 
            passwordAdmin, 
            Constants.Keycloak.ADMIN_CLI_CLIENT_ID);
            this.keycloak = keycloakAdmin;
            
        }       
        catch (Exception e){
            throw new PengeluarankuException("Error connecting keycloak server", HttpStatus.SERVICE_UNAVAILABLE, StatusCode.ERROR);
        }
        }
        return keycloak;
    }

    public Keycloak doLogin(String username, String password){
        Keycloak keycloak = null;
        try{ 
            keycloak = Keycloak.getInstance(keycloakServer, realm, username, password, clientId, clientSecret);
        }
        catch(Exception e){
            log.error("ERROR: ", e);
            throw new PengeluarankuException("Login Error Check Username Password", HttpStatus.BAD_REQUEST, StatusCode.LOGIN_ERROR);
        }
            return keycloak;
    }

    public AccessTokenResponse getToken(Keycloak keycloak){
        AccessTokenResponse accessTokenResponse = null;
        try{
            accessTokenResponse = keycloak.tokenManager().getAccessToken();
            log.info("token :"+accessTokenResponse);
        }
        catch(NotAuthorizedException e){
            log.error("ERROR",e);
            throw new PengeluarankuException("Check Username Password", HttpStatus.BAD_REQUEST, StatusCode.LOGIN_ERROR);

        }
        catch(Exception e){
            log.error("ERROR", e);
            throw new PengeluarankuException("Get Token Error", HttpStatus.BAD_REQUEST, StatusCode.LOGIN_ERROR);
        }
        return accessTokenResponse;
    }
    
}