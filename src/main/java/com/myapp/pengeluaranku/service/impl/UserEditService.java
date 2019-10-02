package com.myapp.pengeluaranku.service.impl;

import java.util.Optional;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.mapper.UserMapper;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.UserService;
import com.myapp.pengeluaranku.util.ValidationUtil;
import com.myapp.pengeluaranku.validator.UserValidator;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserEditService implements UserService {

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public String edit(String uuid, UserReqVO vo){
        User user = Optional.ofNullable(userRepository.findByUuid(uuid))
                    .orElseThrow(()-> new PengeluarankuException("User not found", HttpStatus.NOT_FOUND, StatusCode.DATA_NOT_FOUND));
        user.setName(vo.getName());
        if(!user.getEmail().equals(vo.getEmail())){
            throw new PengeluarankuException("Email must be same", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        }
        if(ValidationUtil.isEmptyOrNull(vo.getAddress())){
            user.setAddress(vo.getAddress());
        }
        user.setPhone(vo.getPhone());
        userRepository.save(user);
        
        return "User successfully added";

    }
}