package com.myapp.pengeluaranku.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name="TRANSAKSI")
@Data
@DynamicUpdate
public class Transaksi extends Base{
    @Column(name="AMOUNT", nullable = false)
    private Integer amount;

    @Column(name="DETAIL_TRANSAKSI", nullable = false)
    private String detailTransaksi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PENGELUARAN_UUID", nullable = false)
    private Pengeluaran pengeluaran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_UUID", nullable = false)
    private User user;
    
}