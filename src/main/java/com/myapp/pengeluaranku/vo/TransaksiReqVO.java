package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransaksiReqVO{
private String name;
private Integer amount;
@JsonProperty("detail_transaksi")
private String detailTransaksi;
public TransaksiReqVO(){};
public TransaksiReqVO(String name, Integer amount){
    this.name = name;
    this.amount = amount;
}
}