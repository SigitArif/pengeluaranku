package com.myapp.pengeluaranku.service.impl;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.mapper.UserMapper;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.UserService;
import com.myapp.pengeluaranku.validator.UserValidator;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserAddService implements UserService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserValidator userValidator;
    @Autowired
    UserRepository userRepository;

    @Override
    public String add(UserReqVO vo) {
        String message = userValidator.validateUserVO(vo);
        if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        User user = userMapper.toModel(vo);
        try{
            userRepository.save(user);
        }
        catch(Exception e){
            throw new PengeluarankuException(e.getMessage(), HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        }
        

        return "User Added Successfully";
    }
}