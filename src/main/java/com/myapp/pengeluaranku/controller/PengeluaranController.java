package com.myapp.pengeluaranku.controller;

import java.util.List;

import javax.xml.ws.Response;

import com.myapp.pengeluaranku.service.PengeluaranService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;
import com.myapp.pengeluaranku.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/pengeluaran")
public class PengeluaranController{

    @Autowired
    PengeluaranService pengeluaranService;
    @PostMapping(value="/add")
    public ResponseEntity<ResultVO> add(@RequestBody PengeluaranRequestVO vo){
        ResultVO result = new ResultVO();
        String results = pengeluaranService.add(vo);
        result.setMessage("Pengeluaran tersimpan");
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }
    @GetMapping(value="/get-all")
    public ResponseEntity<ResultVO> getAll(){
        ResultVO result = new ResultVO();
        List<String> results = pengeluaranService.getAll();
        result.setMessage("Pengeluaran ditemukan");
        result.setResults(results);
        result.setStatus(200);
        return RestUtil.getJsonResponse(result);

    }
    
}