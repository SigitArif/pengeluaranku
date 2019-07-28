package com.myapp.pengeluaranku.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.myapp.pengeluaranku.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class UserRepositoryTest{
@Autowired
UserRepository userRepository;

//     @Test
//     public void findByUUid_posCase(){
//     User model = new User();
//     model.setName("EZP");
//     User user = userRepository.findByUuid("abcde");
//     assertNotNull(user);
// }
}