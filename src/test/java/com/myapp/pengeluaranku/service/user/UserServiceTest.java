package com.myapp.pengeluaranku.service.user;

import static org.junit.Assert.assertNotNull;

import com.myapp.pengeluaranku.vo.AuthResponseVO;
import com.myapp.pengeluaranku.vo.LoginVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

@Autowired
UserService userService;

@Test
public void loginThenSuccess(){
    LoginVO vo = LoginVO.builder()
                .id("sigit.arifanggoro@ai.astra.co.id")
                .password("Demoneyesky0")
                .statusLogin("EMAIL")
                .build();
    AuthResponseVO result = userService.login(vo);
    assertNotNull(result);
    
}
    
}