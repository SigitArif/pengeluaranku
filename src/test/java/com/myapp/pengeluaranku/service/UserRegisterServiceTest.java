package com.myapp.pengeluaranku.service;

import static org.junit.Assert.assertNotNull;

import com.myapp.pengeluaranku.service.user.impl.UserRegisterService;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterServiceTest {
 @Autowired
 UserRegisterService userRegisterService;  

 @Test
 public void registerKeycloakThenSuccess(){
    UserReqVO userVO = new UserReqVO();
    String password = "aspjvjap0j2";

    String result = userRegisterService.createUserKeycloak(userVO, password);
    assertNotNull(result);
}
}