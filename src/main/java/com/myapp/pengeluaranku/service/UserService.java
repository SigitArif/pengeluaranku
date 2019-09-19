package com.myapp.pengeluaranku.service;

import java.util.List;

import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;

public interface UserService{
   default String add(UserReqVO vo){
       return null;
   }

   default String edit(String uuid, UserReqVO vo){
    return null;
}

   default String delete(String uuid){
       return null;
   }
   
    default UserResVO findByUuid(String uuid){
        return null;
    }

    default List<UserResVO> findAll(){
        return null;
    }
   
}