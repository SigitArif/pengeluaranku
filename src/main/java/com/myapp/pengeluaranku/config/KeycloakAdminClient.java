package com.myapp.pengeluaranku.config;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.util.Constants;

import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
public class KeycloakAdminClient {
    @Value("${keycloak.auth-server-url}")
    private String keycloakServer;

    @Value("${admin.keycloak.username}")
    private String usernameAdmin;
    
    @Value("${admin.keycloak.password}")
    private String passwordAdmin;

    @Value("${keycloak.realm}")
    private String realm;
    
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
    
}