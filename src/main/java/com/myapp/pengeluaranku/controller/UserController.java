package com.myapp.pengeluaranku.controller;

import javax.validation.Valid;

import com.myapp.pengeluaranku.service.UserService;
import com.myapp.pengeluaranku.service.impl.UserAddService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.ResultVO;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="pengeluaranku-service/api/v1/user")
public class UserController{
@Autowired
UserAddService userService;
    @PostMapping(value="add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody @Valid UserReqVO vo){
        ResultVO result = new ResultVO();
        Object results = userService.add(vo);
        result.setMessage("User Added");
        result.setStatus(200);
        result.setResults(results);
        return RestUtil.getJsonResponse(result);
        
    }

}