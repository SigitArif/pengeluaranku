package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class PengeluaranResponseVO{
    private String name;
    private String uuid;
    private String code;
    private String type;
    public PengeluaranResponseVO(){};
    public PengeluaranResponseVO(String name, String code, String type, String uuid){
        this.name = name;
        this.code = code;
        this.type = type;
        this.uuid = uuid;
}
}