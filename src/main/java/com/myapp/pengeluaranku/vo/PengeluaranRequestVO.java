package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class PengeluaranRequestVO{
    private String name;
    private String code;
    private String type;
    public PengeluaranRequestVO(){};
    public PengeluaranRequestVO(String name, String code, String type){
        this.name = name;
        this.code = code;
        this.type = type;
}
}