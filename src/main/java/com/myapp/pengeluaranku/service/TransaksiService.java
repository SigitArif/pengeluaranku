package com.myapp.pengeluaranku.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.domain.Transaksi;
import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.mapper.TransaksiMapper;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.repository.TransaksiRepository;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.util.ConverterUtil;
import com.myapp.pengeluaranku.util.ValidationUtil;
import com.myapp.pengeluaranku.validator.TransaksiValidator;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;
import com.myapp.pengeluaranku.vo.TransaksiReqVO2;
import com.myapp.pengeluaranku.vo.TransaksiResVO;

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
@Autowired
TransaksiMapper transaksiMapper;

    public String add(TransaksiReqVO vo){
        String message = transaksiValidator.validateTransaksi(vo);
         if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        Transaksi model = new Transaksi();
        
        Date trxDate = ConverterUtil.convertStringTimeStampToDate(vo.getTanggalTransaksi());
        Pengeluaran pengeluaran = pengeluaranRepository.findByName(vo.getName());
        User user = userRepository.findByUuid("63800da4-0d02-4746-98c3-b6b902d3c509");
        
        model.setAmount(vo.getAmount());
        model.setPengeluaran(pengeluaran);
        model.setUser(user);
        model.setDetailTransaksi(vo.getDetailTransaksi());
        model.setTrxDate(trxDate);
        transaksiRepository.save(model);
         return "Data saved";

    }

	public List<TransaksiResVO> list() {
        List<Transaksi> transaksi = transaksiRepository.findAll();
        List<TransaksiResVO> result = transaksiMapper.toVO(transaksi);
		return result;
	}

	public String addTransaksi(TransaksiReqVO2 vo) {
        String message = transaksiValidator.validateTransaksi2(vo);
         if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        Pengeluaran pengeluaran = pengeluaranRepository.findByUuid(vo.getPengeluaranId());
        if(pengeluaran==null) throw new PengeluarankuException("User Not Found", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        User user = userRepository.findByUuid(vo.getUserId());
        if(user==null) throw new PengeluarankuException("Pengeluaran Not Found", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        Transaksi transaksi = new Transaksi();
        transaksi.setAmount(vo.getAmount());
        transaksi.setCreatedBy(user.getName());
        transaksi.setDetailTransaksi(vo.getDetailTransaksi());
        transaksi.setUser(user);
        transaksi.setPengeluaran(pengeluaran);
        transaksiRepository.save(transaksi);
        return "Data saved";
    } 
    public String deleteTransaksi(String uuid){
        if(ValidationUtil.isEmptyOrNull(uuid)){
            throw new PengeluarankuException("Uuid can't be empty", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        }
        else{
            Transaksi transaksi = transaksiRepository.findByUuid(uuid);
            if(transaksi == null){
                throw new PengeluarankuException("Transaksi not found", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
            }
            transaksiRepository.delete(transaksi);
        }
        return "Transaksi terhapus";
    }
}