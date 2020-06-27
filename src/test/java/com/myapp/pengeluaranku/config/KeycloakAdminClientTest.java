package com.myapp.pengeluaranku.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KeycloakAdminClientTest {

    @Autowired
    KeycloakAdminClient keycloakAdminClient;
    @Test
    public void testConfig(){
       Keycloak keycloak = keycloakAdminClient.getInstance();
       assertNotNull(keycloak);

    }
}