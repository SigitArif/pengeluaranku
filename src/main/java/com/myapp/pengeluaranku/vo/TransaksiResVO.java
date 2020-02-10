package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransaksiResVO{
    private String uuid;
    private String name;
    private Integer amount;
    @JsonProperty("detail_transaksi")
    private String detailTransaksi;
    @JsonProperty("tanggal_transaksi")
    private String tanggalTransaksi;
    public TransaksiResVO(){};
    public TransaksiResVO(String name, Integer amount, String uuid){
        this.name = name;
        this.amount = amount;
        this.uuid = uuid;
    }
}