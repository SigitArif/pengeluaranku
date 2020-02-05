package com.myapp.pengeluaranku.validator;

import java.util.HashMap;
import java.util.Map;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.util.ValidationUtil;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;
import com.myapp.pengeluaranku.vo.TransaksiReqVO2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TransaksiValidator{

@Autowired
MandatoryValidator mandatoryValidator;

@Autowired
PengeluaranRepository pengeluaranRepository;
    public <T> String validateTransaksi(TransaksiReqVO vo) {
        Map<String, T> mandatories = new HashMap();
        mandatories.put("Name", (T) vo.getName());
        mandatories.put("Amount", (T) vo.getAmount());
        mandatories.put("Detail Transaksi", (T) vo.getDetailTransaksi());
        String mandatoryCheck = mandatoryValidator.validateMandatoryFields(mandatories);
        if(mandatoryCheck!=null){
            return mandatoryCheck;
        }
        // check name
        Pengeluaran model = pengeluaranRepository.findByName(vo.getName());
        if(model==null){
            return "Pengeluaran not found";
        }
        try{
            Long timestamp = Long.parseLong(vo.getTanggalTransaksi());
            
        }
        catch(Exception e){
            throw new PengeluarankuException("Invalid format tanggal transaksi", HttpStatus.BAD_REQUEST, StatusCode.ERROR);

        }

        
        

        return null;

    }
    public String validateTransaksi2(TransaksiReqVO2 vo){
        if(ValidationUtil.isEmptyOrNull(vo.getUserId())) return "User id can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getPengeluaranId())) return "Pengeluaran id can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getAmount())) return "Amount can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getDetailTransaksi())) return "Detail transaksi can't be empty";
        return null;
        
    }
}