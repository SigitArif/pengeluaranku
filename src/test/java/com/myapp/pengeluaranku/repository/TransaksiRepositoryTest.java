package com.myapp.pengeluaranku.repository;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.myapp.pengeluaranku.domain.Transaksi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransaksiRepositoryTest {

    @Autowired
    TransaksiRepository transaksiRepository;

    @Test
    public void transaksiTest() throws ParseException {
        Integer month= 2;
        Integer year = 2020;
        String type = "K";
        String date = "2020-02-08";
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date newDate = dateFormat.parse(date);
        

        List<Transaksi> pengeluaran = transaksiRepository.selectTrans(date);
        assertNotNull(pengeluaran);
    }
}