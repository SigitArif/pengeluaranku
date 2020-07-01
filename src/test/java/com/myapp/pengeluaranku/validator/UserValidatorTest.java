package com.myapp.pengeluaranku.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Id can't be empty";
    assertEquals(expected, actual);
}

@Test
// 2. Login : id "" then "Id can't be empty"
public void loginIdEmptyThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .id("")
                .password("password")
                .statusLogin("statusLogin").build();
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Id can't be empty";
    assertEquals(expected, actual);
}

@Test
// 3. Login : password null then "Id can't be empty"
public void loginPasswordNullThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .id("sigityounglearner@gmail.com")
                .statusLogin("statusLogin").build();
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Password can't be empty";
    assertEquals(expected, actual);
}

@Test
// 4. Login : password null then "Id can't be empty"
public void loginPasswordEmptyThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .id("sigityounglearner@gmail.com")
                .password("")
                .statusLogin("statusLogin").build();
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Password can't be empty";
    assertEquals(expected, actual);
}

@Test
// 5. Login : password null then "Id can't be empty"
public void loginStatusLoginNullThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .id("sigityounglearner@gmail.com")
                .password("password").build();
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Status login can't be empty";
    assertEquals(expected, actual);
}
    
}