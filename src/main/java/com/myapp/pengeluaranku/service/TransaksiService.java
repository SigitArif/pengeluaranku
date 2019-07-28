package com.myapp.pengeluaranku.service;

import javax.transaction.Transactional;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.domain.Transaksi;
import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.repository.TransaksiRepository;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.validator.TransaksiValidator;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransaksiService{
@Autowired
TransaksiValidator transaksiValidator;

@Autowired
PengeluaranRepository pengeluaranRepository;

@Autowired
UserRepository userRepository;

@Autowired
TransaksiRepository transaksiRepository;

    public String add(TransaksiReqVO vo){
        String message = transaksiValidator.validateTransaksi(vo);
         if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        Transaksi model = new Transaksi();
        Pengeluaran pengeluaran = pengeluaranRepository.findByName(vo.getName());
        User user = userRepository.findByUuid("abcde");
        model.setAmount(vo.getAmount());
        model.setPengeluaran(pengeluaran);
        model.setUser(user);
        model.setDetailTransaksi(vo.getDetailTransaksi());
        transaksiRepository.save(model);
         return "Data saved";

    } 
}