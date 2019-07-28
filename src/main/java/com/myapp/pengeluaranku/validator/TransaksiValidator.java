package com.myapp.pengeluaranku.validator;

import java.util.HashMap;
import java.util.Map;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;

import org.springframework.beans.factory.annotation.Autowired;
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
        

        return null;

    }
}