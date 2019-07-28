package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class ResultVO{
    private Integer status;
    private String message;
    private Object results;

    public ResultVO() {
    }

    public ResultVO(Integer status, String message, Object results) {
        this.status = status;
        this.message = message;
        this.results = results;
    }
}