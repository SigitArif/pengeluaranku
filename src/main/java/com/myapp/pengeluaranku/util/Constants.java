package com.myapp.pengeluaranku.util;

import org.springframework.beans.factory.annotation.Value;

public class Constants {
    
    public static final class Keycloak {
   
        public static final String REALM_MASTER = "master";
       
        public static final String ADMIN_CLI_CLIENT_ID = "admin-cli";
       
}
    public static final class Roles {
        public static final String ADMIN = "admin";
        public static final String CUSTOMERS = "customers";
    }
}