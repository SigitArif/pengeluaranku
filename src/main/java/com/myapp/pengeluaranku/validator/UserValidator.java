package com.myapp.pengeluaranku.validator;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator{
@Autowired
UserRepository userRepository;

public String validateUserVO(UserReqVO vo){
    // jika find by email exist
    
    User model = userRepository.findByEmail(vo.getEmail());
    if(model!=null){
        return "Email already exist";
    }


        return null;

}
}