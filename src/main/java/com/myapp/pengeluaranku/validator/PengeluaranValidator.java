package com.myapp.pengeluaranku.validator;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PengeluaranValidator{
@Autowired
PengeluaranRepository pengeluaranRepository;
    public String validateAdd(PengeluaranRequestVO vo){
        if(vo.getName()==null||vo.getName().isEmpty()) {
            return "Name can't be empty";    
        }

        Pengeluaran model = pengeluaranRepository.findByName(vo.getName());
        if(model!=null){
            return "Name already exist";
        }

        if(vo.getType()==null||vo.getType().isEmpty()) {
            return "Type can't be empty";    
        }

        if(vo.getCode()==null||vo.getCode().isEmpty()) {
            return "Code can't be empty";    
        }
        return null;
    }
}