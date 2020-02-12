package com.myapp.pengeluaranku.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransaksiServiceTest{

    @Autowired
    TransaksiService transaksiService;
    @Test
    public void countTrx(){
    String monthAndYear = "2020-01";
    String type ="K";
    int totalAmount = transaksiService.countTrxAmount(monthAndYear, type);
    assertNotNull(totalAmount);
    }
}