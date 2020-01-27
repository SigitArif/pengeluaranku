package com.myapp.pengeluaranku.controller;

import java.util.List;

import javax.xml.ws.Response;

import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.service.PengeluaranService;
import com.myapp.pengeluaranku.service.TransaksiService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;
import com.myapp.pengeluaranku.vo.ResultVO;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;
import com.myapp.pengeluaranku.vo.TransaksiReqVO2;
import com.myapp.pengeluaranku.vo.TransaksiResVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/transaksi")
public class TransaksiController{

    @Autowired
    TransaksiService transaksiService;
    @PostMapping(value="/add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody TransaksiReqVO vo){
        ResultVO result = new ResultVO();
        String results = transaksiService.add(vo);
        result.setMessage(StatusCode.OK.toString());
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }

    @PostMapping(value="/add-transaksi")
    @ResponseBody
    public ResponseEntity<ResultVO> addTransaksi(@RequestBody TransaksiReqVO2 vo){
        ResultVO result = new ResultVO();
        String results = transaksiService.addTransaksi(vo);
        result.setMessage(StatusCode.OK.toString());
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }
    

    @GetMapping(value="/list")
    @ResponseBody
    public ResponseEntity<ResultVO> list(){
        ResultVO result = new ResultVO();
        List<TransaksiResVO> results = transaksiService.list();
        result.setMessage(StatusCode.OK.toString());
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<ResultVO> delete(@RequestParam(value="uuid", required = false) String uuid){
        ResultVO result = new ResultVO();
        String results = transaksiService.deleteTransaksi(uuid);
        result.setMessage(StatusCode.OK.toString());
        result.setResults(results);
        result.setStatus(200);
        return RestUtil.getJsonResponse(result);
    }
    
}