package com.myapp.pengeluaranku.service.impl;

import java.util.List;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.mapper.UserMapper;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.service.UserService;
import com.myapp.pengeluaranku.validator.UserValidator;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGetService implements UserService {
    @Autowired
    UserValidator userValidator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserResVO> findAll() {
        List<User> users = userRepository.findByIsDeleteIsNull();
        List<UserResVO> vos = userMapper.toVO(users);
        return vos;

    }
}