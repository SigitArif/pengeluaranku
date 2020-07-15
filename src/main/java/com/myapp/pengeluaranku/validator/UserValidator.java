package com.myapp.pengeluaranku.validator;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.util.ValidationUtil;
import com.myapp.pengeluaranku.vo.LoginVO;
import com.myapp.pengeluaranku.vo.RegisterReqVO;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public void validateLogin(LoginVO vo){
        String message = validateLoginMessage(vo);
        if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);

    }

    public String validateLoginMessage(LoginVO vo){
        if(ValidationUtil.isEmptyOrNull(vo.getId())) return "Id can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getPassword())) return "Password can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getStatusLogin())) return "Status login can't be empty";        

        return null;
    }
    public void validateRegister(RegisterReqVO vo){
        String message = validateRegisterMessage(vo);
        if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);

    }

    public String validateRegisterMessage(RegisterReqVO vo){
        if(ValidationUtil.isEmptyOrNull(vo.getPassword())) return "Password can't be empty";
        UserReqVO user = vo.getUser();
        if(ValidationUtil.isEmptyOrNull(user.getName())) return "Name can't be empty";
        if(ValidationUtil.isEmptyOrNull(user.getPhone())) return "Phone can't be empty";
        
        return null;
    }

}