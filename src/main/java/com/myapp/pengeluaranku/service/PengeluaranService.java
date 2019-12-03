package com.myapp.pengeluaranku.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.util.ValidationUtil;
import com.myapp.pengeluaranku.validator.PengeluaranValidator;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PengeluaranService{

@Autowired
PengeluaranRepository pengeluaranRepository;

@Autowired
PengeluaranValidator pengeluaranValidator;

@Transactional
public String add(PengeluaranRequestVO vo){
    String message = pengeluaranValidator.validateAdd(vo);
    if(message!=null) throw new PengeluarankuException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
    Pengeluaran model = new Pengeluaran();
    model.setCode(vo.getCode());
    model.setCreatedBy("sigit");
    model.setName(vo.getName());
    model.setType(vo.getType());
    pengeluaranRepository.save(model);
        return "Pengeluaran tersimpan";


}

public String edit(PengeluaranRequestVO vo, String uuid){
    // validate input
    pengeluaranValidator.validateEdit(vo, uuid);
    Pengeluaran pengeluaran = pengeluaranRepository.findByUuid(uuid);
    pengeluaran.setName(vo.getName());
    pengeluaran.setCode(vo.getCode());
    pengeluaran.setType(vo.getType());
    pengeluaran.setModificationDate(new Date());
    pengeluaran.setModifiedBy("sigit");
    pengeluaranRepository.saveAndFlush(pengeluaran);


    return "Pengeluaran sukses terupdate";
}

public List<String> getAll(){
    List<Pengeluaran> listPengeluaran = pengeluaranRepository.findAll();
    List<String> vos = new ArrayList<>();
    for(Pengeluaran pengeluaran : listPengeluaran){
        vos.add(pengeluaran.getName());
    }
    System.out.println(vos);
        return vos;
    
}

public String delete(String uuid) {
    if(ValidationUtil.isEmptyOrNull(uuid)){
        throw new PengeluarankuException("Uuid can't be empty", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
    }
    else{
        Pengeluaran pengeluaran = pengeluaranRepository.findByUuid(uuid);
        if(pengeluaran == null){
            throw new PengeluarankuException("Pengeluaran not found", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        }
        pengeluaranRepository.delete(pengeluaran);
    }
	return null;
}
}