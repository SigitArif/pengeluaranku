package com.myapp.pengeluaranku.controller;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.service.TransaksiService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/statistic")
public class StatisticController{
    
    @Autowired
    TransaksiService transaksiService;

    @GetMapping(value="/monthly")
    @ResponseBody
    public ResponseEntity<ResultVO> countTrx(@RequestParam(value="month", required = false)String month, 
                                            @RequestParam(value="type", required=false) String type){
        
        ResultVO result = new ResultVO();
        Integer results = transaksiService.countTrxAmount(month, type);
        result.setMessage(StatusCode.OK.toString());
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);                                        
        
    }
}