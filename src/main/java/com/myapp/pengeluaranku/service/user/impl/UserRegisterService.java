package com.myapp.pengeluaranku.service.user.impl;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.common.hash.Hashing;
import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.service.user.UserService;
import com.myapp.pengeluaranku.util.Constants;
import com.myapp.pengeluaranku.vo.RegisterReqVO;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;

import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService implements UserService {

    @Value("${keycloak.auth-server-url}")
    private String keycloakServer;
    
    @Value("${admin.keycloak.username}")
    private String usernameAdmin;
    
    @Value("${admin.keycloak.password}")
    private String passwordAdmin;

    @Value("${keycloak.realm}")
    private String realm;

    @Override
    public UserResVO register(RegisterReqVO vo){
        KeycloakAccount keycloakAccount;
        Keycloak keycloakAdmin;

    
        try{
            keycloakAdmin = Keycloak.getInstance(keycloakServer, Constants.Keycloak.REALM_MASTER, usernameAdmin
            , passwordAdmin, Constants.Keycloak.ADMIN_CLI_CLIENT_ID);
        }
        catch (Exception e){
            throw new PengeluarankuException("Error connecting keycloak server", HttpStatus.SERVICE_UNAVAILABLE, StatusCode.ERROR);
        }
        createUserKeycloak(keycloakAdmin, vo.getUser(), vo.getPassword());

        return null;
    }

    public String createUserKeycloak(Keycloak keycloak, UserReqVO userVO, String password){
        // set user identifiaction
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(userVO.getEmail());
        userRepresentation.setFirstName(userVO.getName());
        userRepresentation.setEmail(userVO.getEmail());
        userRepresentation.setEmailVerified(true);
        userRepresentation.setEnabled(true);
        
        // create user 
        Response response = keycloak.realm(realm).users().create(userRepresentation);
        String ssoId = getCreatedId(response);
        
        // set role to user
        RoleRepresentation roleRepresentation = getRole(keycloak, Constants.Roles.CUSTOMERS);
        if(roleRepresentation==null) throw new PengeluarankuException("Role not found in keycloak", 
                                    HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        List<RoleRepresentation> addAdminRole = new ArrayList<>();
        addAdminRole.add(roleRepresentation);

        keycloak.realm(realm).users().get(ssoId).roles().realmLevel().add(addAdminRole);

        // create password
        CredentialRepresentation credential = new CredentialRepresentation();
        password = hashPassword(password);
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        credential.setTemporary(false);

        // set password
        keycloak.realm(realm).users().get(ssoId).resetPassword(credential);

        return ssoId;
    }
    private String getCreatedId(Response response) {
        //set message
        
        URI location = response.getLocation();
        if (!response.getStatusInfo().equals(Response.Status.CREATED)) {
            throw new PengeluarankuException("Username keycloak already exist", HttpStatus.BAD_REQUEST
            , StatusCode.ERROR);
        }
        if (location == null) {
            return null;
        }
        String path = location.getPath();
        return path.substring(path.lastIndexOf('/') + 1);
    }

    private RoleRepresentation getRole(Keycloak keycloak, String role) {
        return keycloak.realm(realm).roles().get(role).toRepresentation();
    }

    private String hashPassword(String password){
        String signature = Hashing.sha256()
         .hashString(password, StandardCharsets.UTF_8)
         .toString();
        return signature;
    }
}