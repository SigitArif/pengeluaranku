package com.myapp.pengeluaranku.controller;

import javax.validation.Valid;

import com.myapp.pengeluaranku.service.UserService;
import com.myapp.pengeluaranku.service.impl.UserAddService;
import com.myapp.pengeluaranku.service.impl.UserDeleteService;
import com.myapp.pengeluaranku.service.impl.UserEditService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.ResultVO;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="pengeluaranku-service/api/v1/user")
public class UserController{

UserAddService userAddService;
UserEditService userEditService;
UserDeleteService userDeleteService;
@Autowired
public UserController(UserAddService userAddService, UserEditService userEditService, UserDeleteService userDeleteService){
   this.userAddService = userAddService;
   this.userEditService = userEditService;
   this.userDeleteService = userDeleteService;
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

}