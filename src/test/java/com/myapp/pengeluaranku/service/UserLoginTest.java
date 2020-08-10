package com.myapp.pengeluaranku.service;

import static org.junit.Assert.assertNotNull;

import com.myapp.pengeluaranku.enums.StatusLogin;
import com.myapp.pengeluaranku.service.user.impl.UserLoginService;
import com.myapp.pengeluaranku.service.user.impl.UserRegisterService;
import com.myapp.pengeluaranku.vo.AuthResponseVO;
import com.myapp.pengeluaranku.vo.LoginVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserLoginTest {
@Autowired
UserLoginService userLoginService;

//1. Test success login
// @Test
// public void loginThenOK(){

//     LoginVO vo = LoginVO.builder()
//                 .id("sigit.arifanggoro@ai.astra.co.id")
//                 .password("aspjvjap0j2")
//                 .statusLogin("EMAIL")
//                 .build();
//     AuthResponseVO result = userLoginService.login(vo);
//     assertNotNull(result);

//     }
    
}