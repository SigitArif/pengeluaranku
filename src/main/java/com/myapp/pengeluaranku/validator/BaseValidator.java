package com.myapp.pengeluaranku.validator;

import org.springframework.stereotype.Component;

@Component
public class BaseValidator{

    public Boolean isEmptyOrNull(String t) {        
        return t==null||t.equals("");
    }

    public Boolean isEmpty(String t){
        return t.equals("");
    }

    public Boolean isNull(String t){
        return t==null;
    }
}