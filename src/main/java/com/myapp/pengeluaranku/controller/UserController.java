package com.myapp.pengeluaranku.controller;

import javax.validation.Valid;

import com.myapp.pengeluaranku.service.user.impl.*;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.*;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value ="pengeluaranku-service/api/v1/user")
public class UserController{

UserAddService userAddService;
UserEditService userEditService;
UserDeleteService userDeleteService;
UserRegisterService userRegisterService;
UserLoginService userLoginService;

@Autowired
public UserController(UserAddService userAddService, UserEditService userEditService, 
                    UserDeleteService userDeleteService, UserRegisterService userRegisterService,
                    UserLoginService userLoginService){
   this.userAddService = userAddService;
   this.userEditService = userEditService;
   this.userDeleteService = userDeleteService;
   this.userRegisterService = userRegisterService;
   this.userLoginService = userLoginService;
}

    @PostMapping(value="add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody @Valid UserReqVO vo){
        ResultVO result = new ResultVO();
        Object results = userAddService.add(vo);
        result.setMessage("User Added");
        result.setStatus(200);
        result.setResults(results);
        return RestUtil.getJsonResponse(result);
        
    }
    @PostMapping(value="edit")
    @ResponseBody
    public ResponseEntity<ResultVO> edit(@RequestBody @Valid UserReqVO vo,
                                         @RequestParam(value = "uuid", required = false) String uuid){
                                
        ResultVO result = new ResultVO();
        Object results = userEditService.edit(uuid, vo);
        result.setMessage("User Edited");
        result.setStatus(200);
        result.setResults(results);
        return RestUtil.getJsonResponse(result);

    }

    @DeleteMapping(value="delete")
    @ResponseBody
    public ResponseEntity<ResultVO> delete (@RequestParam (value = "uuid", required = false) String uuid){
        ResultVO result = new ResultVO();
        Object results = userDeleteService.delete(uuid);
        result.setMessage("User Edited");
        result.setStatus(200);
        result.setResults(results);
        return RestUtil.getJsonResponse(result);

    }

    @PostMapping(value="register")
    @ResponseBody
    public ResponseEntity<ResultVO> register(@RequestBody RegisterReqVO vo){
        ResultVO result = new ResultVO();
        UserResVO results = userRegisterService.register(vo);
        result.setMessage("User Registered");
        result.setStatus(HttpStatus.SC_CREATED);
        result.setResults(results);        
        return RestUtil.getJsonResponse(result);
    }

    @PostMapping(value="login")
    @ResponseBody
    public ResponseEntity<ResultVO> login(@RequestBody LoginVO vo) {
        ResultVO result = new ResultVO();
        AuthResponseVO results = userLoginService.login(vo);
        result.setMessage("Login Success");
        result.setStatus(HttpStatus.SC_OK);
        result.setResults(results);
        return RestUtil.getJsonResponse(result);
    }

}