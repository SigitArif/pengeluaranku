package com.myapp.pengeluaranku.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.myapp.pengeluaranku.vo.LoginVO;
import com.myapp.pengeluaranku.vo.RegisterReqVO;
import com.myapp.pengeluaranku.vo.UserReqVO;

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
// 3. Login : password null then "Password can't be empty"
public void loginPasswordNullThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .id("sigityounglearner@gmail.com")
                .statusLogin("statusLogin").build();
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Password can't be empty";
    assertEquals(expected, actual);
}

@Test
// 4. Login : password empty then "Password can't be empty"
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
// 5. Login : login status null then "Status login can't be empty"
public void loginStatusLoginNullThenErrorMessage(){
    LoginVO vo = LoginVO.builder()
                .id("sigityounglearner@gmail.com")
                .password("password").build();
    String actual = userValidator.validateLoginMessage(vo);
    String expected = "Status login can't be empty";
    assertEquals(expected, actual);
}

// 6. Register : password null then error
@Test 
public void register_passwordNullThenErrorMessage(){
    UserReqVO user = new UserReqVO();
    user.setAddress("address");
    user.setEmail("email@gmail.com");
    user.setName("name123");
    user.setPhone("083881910083");
    RegisterReqVO vo = new RegisterReqVO();
    vo.setUser(user);
    String actual = userValidator.validateRegisterMessage(vo);
    String expected = "Password can't be empty";
    assertEquals(expected, actual);
}

// 7. Register: password empty then error
@Test
public void register_passwordEmptyThenErrorMessage(){
    UserReqVO user = new UserReqVO();
    user.setAddress("address");
    user.setEmail("email@gmail.com");
    user.setName("name123");
    user.setPhone("083881910083");
    RegisterReqVO vo = new RegisterReqVO();
    vo.setPassword("");
    vo.setUser(user);
    String actual = userValidator.validateRegisterMessage(vo);
    String expected = "Password can't be empty";
    assertEquals(expected, actual);
}

// 8. Register: name null then error 
@Test
public void register_nameNullThenErrorMessage(){
    UserReqVO user = new UserReqVO();
    user.setAddress("address");
    user.setEmail("email@gmail.com");
    user.setPhone("083881910083");
    RegisterReqVO vo = new RegisterReqVO();
    vo.setPassword("12345");
    vo.setUser(user);
    String actual = userValidator.validateRegisterMessage(vo);
    String expected = "Name can't be empty";
    assertEquals(expected, actual);
}

// 9. Register: name empty then error 
@Test
public void register_nameEmptyThenErrorMessage(){
    UserReqVO user = new UserReqVO();
    user.setAddress("address");
    user.setName("");
    user.setEmail("email@gmail.com");
    user.setPhone("083881910083");
    RegisterReqVO vo = new RegisterReqVO();
    vo.setPassword("12345");
    vo.setUser(user);
    String actual = userValidator.validateRegisterMessage(vo);
    String expected = "Name can't be empty";
    assertEquals(expected, actual);
}

// 10. Register: phone null then error 
@Test
public void register_phoneNullThenErrorMessage(){
    UserReqVO user = new UserReqVO();
    user.setName("name234");
    user.setAddress("address");
    user.setEmail("email@gmail.com");
    user.setPhone(null);
    RegisterReqVO vo = new RegisterReqVO();
    vo.setPassword("12345");
    vo.setUser(user);
    String actual = userValidator.validateRegisterMessage(vo);
    String expected = "Phone can't be empty";
    assertEquals(expected, actual);
}

// 11. Register: phone empty then error 
@Test
public void register_phoneEmptyThenErrorMessage(){
    UserReqVO user = new UserReqVO();
    user.setName("namasaya");
    user.setAddress("address");
    user.setEmail("email@gmail.com");
    user.setPhone("");
    RegisterReqVO vo = new RegisterReqVO();
    vo.setPassword("12345");
    vo.setUser(user);
    String actual = userValidator.validateRegisterMessage(vo);
    String expected = "Phone can't be empty";
    assertEquals(expected, actual);
}
// 12. Register: email null then error
// 13. Register: email empty then error
// 14. Register: address null then error
// 15. Register: address empty then error
// 16. Register: email not regex format then error
// 17. Register: phone not number format then error
// 18. Register: phone not in range 10 - 13 then error
// 19. Register: phone duplicate then error
// 20. Register: email duplicate then error





}