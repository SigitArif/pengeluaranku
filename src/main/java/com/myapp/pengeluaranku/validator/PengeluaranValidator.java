package com.myapp.pengeluaranku.validator;

import java.util.HashMap;
import java.util.Map;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.PengeluarankuException;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PengeluaranValidator extends BaseValidator{
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
    
    public String validateEditNotFound(PengeluaranRequestVO vo, String uuid) {
        Pengeluaran pengeluaran = pengeluaranRepository.findByUuid(uuid);
        if(pengeluaran==null) return "Pengeluaran Not Found";

        return null;
    }

    public String validateEditBadRequest(PengeluaranRequestVO vo, String uuid) {
        if(isEmptyOrNull(uuid)) return "Uuid can't be empty";
        if(isEmptyOrNull(vo.getName())) return "Name can't be empty";
        if(isEmptyOrNull(vo.getCode())) return "Code can't be empty";
        if(isEmptyOrNull(vo.getType())) return "Type can't be empty";
        return null;
    }

	public void validateEdit(PengeluaranRequestVO vo, String uuid) {
        String validateEditBadRequest = validateEditBadRequest(vo,uuid);
        if(validateEditBadRequest!=null) throw new PengeluarankuException(validateEditBadRequest, HttpStatus.BAD_REQUEST, StatusCode.ERROR);

        String validateEditNotFound = validateEditNotFound(vo,uuid);
        if(validateEditNotFound!=null) throw new PengeluarankuException(validateEditNotFound, HttpStatus.NOT_FOUND, StatusCode.DATA_NOT_FOUND);
		
	}
}