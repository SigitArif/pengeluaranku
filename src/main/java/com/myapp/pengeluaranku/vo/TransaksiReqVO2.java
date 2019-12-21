package com.myapp.pengeluaranku.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransaksiReqVO2{
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("pengeluaran_id")
    private String pengeluaranId;
    private Integer amount;
    @JsonProperty("detail_transaksi")
    private String detailTransaksi;
    public TransaksiReqVO2(){};
    public TransaksiReqVO2(String userId, Integer amount){
        this.userId = userId;
        this.amount = amount;
}
}