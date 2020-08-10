package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransaksiReqVO2{
    @JsonProperty("pengeluaran_id")
    private String pengeluaranId;
    private Integer amount;
    @JsonProperty("detail_transaksi")
    private String detailTransaksi;
    @JsonProperty("tanggal_transaksi")
    private String tanggalTransaksi;
    public TransaksiReqVO2(){};
    
}