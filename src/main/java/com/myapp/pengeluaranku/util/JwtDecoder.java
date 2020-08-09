package com.myapp.pengeluaranku.util;

import com.google.gson.Gson;
import com.myapp.pengeluaranku.vo.JwtVO;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JwtDecoder {
    
    public String getUsername(String auth) {
        String[] authsplit = auth.split("\\.");
        String jwt = authsplit[1];
        byte[] bytedecoded = Base64.getDecoder().decode(jwt);
        String jwtdecoded = new String(bytedecoded);

        Gson gson = new Gson();
        JwtVO jwtVO = gson.fromJson(jwtdecoded, JwtVO.class);

        return jwtVO.getPreferred_username();
    }

    public String[] getRoles(String auth) {
        String[] authsplit = auth.split("\\.");
        String jwt = authsplit[1];
        byte[] bytedecoded = Base64.getDecoder().decode(jwt);
        String jwtdecoded = new String(bytedecoded);

        Gson gson = new Gson();
        JwtVO jwtVO = gson.fromJson(jwtdecoded, JwtVO.class);
        String[] roles = jwtVO.getRealm_access().getRoles();


        return roles;

    }

    public String validateRoles(String[] roles) {
        String availableRoles = "mitra,admin,consumer,surveyor";
        String[] availables = availableRoles.split(",");

        String message = "role not match";
        for (String role : roles) {
            for (String available : availables) {
                if (role.equals(available)) {
                    message = null;
                }
                ;
            }
        }
        return message;

    }
}