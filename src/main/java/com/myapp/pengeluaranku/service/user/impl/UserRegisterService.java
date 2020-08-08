package com.myapp.pengeluaranku.service.user.impl;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.common.hash.Hashing;
import com.myapp.pengeluaranku.config.KeycloakAdminClient;
import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.user.UserService;
import com.myapp.pengeluaranku.util.Constants;
import com.myapp.pengeluaranku.validator.UserValidator;
import com.myapp.pengeluaranku.vo.RegisterReqVO;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;

import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService implements UserService {

    @Value("${keycloak.realm}")
    private String realm;

    @Autowired
    private KeycloakAdminClient keycloakAdminClient;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserResVO register(RegisterReqVO vo){
        // validate req vo
        userValidator.validateRegister(vo);
        
        createUserKeycloak(vo.getUser(), vo.getPassword());

        // user data
        UserReqVO userReqVO = vo.getUser();
        String address = userReqVO.getAddress();
        String email = userReqVO.getEmail();
        String name = userReqVO.getName();
        String phone = userReqVO.getPhone();
        
        // save to DB
        User user = new User();
        user.setAddress(address);
        user.setCreatedBy(email);
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);

        User userSaved = userRepository.save(user);    
        // give Response
        UserResVO userResVO = new UserResVO();
        userResVO.setUuid(userSaved.getUuid());
        userResVO.setAddress(address);
        userResVO.setEmail(email);
        userResVO.setName(name);
        userResVO.setPhone(phone);
        
        return userResVO;
    }

    public String createUserKeycloak(UserReqVO userVO, String password){
        // set Keycloak
        Keycloak keycloak = keycloakAdminClient.getInstance();
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

    public String hashPassword(String password){
        String signature = Hashing.sha256()
         .hashString(password, StandardCharsets.UTF_8)
         .toString();
        return signature;
    }
}