package com.myapp.pengeluaranku.repository;

import java.util.Date;
import java.util.List;

import com.myapp.pengeluaranku.domain.Transaksi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TransaksiRepository extends JpaRepository<Transaksi,Integer>, JpaSpecificationExecutor<Transaksi>{
   Transaksi findByUuid(String uuid); 

   @Query(value="SELECT * FROM transaksi WHERE date(transaction_date) = date(?1)", nativeQuery = true)
   List<Transaksi> selectTrans(@Param("date")String date);

}