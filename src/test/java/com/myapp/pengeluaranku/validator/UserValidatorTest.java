package com.myapp.pengeluaranku.validator;

import com.myapp.pengeluaranku.vo.LoginVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserValidatorTest {
@Autowired
UserValidator userValidator;

@Test
// 1. Login : id null then "Id can't be empty"
public void loginIdNullThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .password("password")
                .statusLogin("statusLogin").build();
    userValidator.validateLoginMessage(vo);
}
    
}