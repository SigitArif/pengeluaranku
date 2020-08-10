package com.myapp.pengeluaranku.service.user.impl;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.mapper.UserMapper;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.user.UserService;
import com.myapp.pengeluaranku.util.JwtDecoder;
import com.myapp.pengeluaranku.vo.UserResVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtDecoder jwtDecoder;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserResVO detail(String auth){
        // get email from jwt
        String email = jwtDecoder.getUsername(auth);

        //find email in db
        User user = userRepository.findByEmail(email);

        if(user==null) throw new PengeluarankuException("Username not found", HttpStatus.NOT_FOUND, StatusCode.DATA_NOT_FOUND);

        return userMapper.toVO(user);
    }
    
}