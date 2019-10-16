package com.myapp.pengeluaranku.service.impl;

import java.util.Date;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteService implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public String delete(String uuid){
        User user = userRepository.findByUuid(uuid);
        user.setIsDelete(new Date());
        userRepository.save(user);
        return "User with uuid " + uuid +" deleted successfully";

    }
}