package com.myapp.pengeluaranku.repository;

import com.myapp.pengeluaranku.domain.Transaksi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransaksiRepository extends JpaRepository<Transaksi,Integer>, JpaSpecificationExecutor<Transaksi>{
   Transaksi findByUuid(String uuid); 
}