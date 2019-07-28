package com.myapp.pengeluaranku.validator;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MandatoryValidator{

    public <T> String validateMandatoryFields(Map<String, T> mandatories) {
        for (Map.Entry<String, T> entry : mandatories.entrySet()) {
            if(entry.getValue()==null){
                return entry.getKey()+" can't be empty";
            }
        }
        return null;
        
    }
}