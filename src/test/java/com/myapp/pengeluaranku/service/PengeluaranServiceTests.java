package com.myapp.pengeluaranku.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PengeluaranServiceTests{
@Autowired
PengeluaranService pengeluaranService;
@Autowired
PengeluaranRepository pengeluaranRepository;
    // 1. Positive case
    // @Test
    // public void addSuccess(){
    // String name = "Makan";
    // String code = "M";
    // String type = "K";
    // PengeluaranRequestVO vo = new PengeluaranRequestVO(name, code, type);
    // String expected = "Pengeluaran tersimpan";
    // String actual = pengeluaranService.add(vo);
    // assertEquals(expected,actual);
    // }
    // 2. name null
    // @Test
    // public void nameIsNull(){
    // PengeluaranRequestVO vo = new PengeluaranRequestVO();
    // String expected = "Name can't be empty";
    // String actual = pengeluaranService.add(vo);
    // assertEquals(expected, actual);
    // }

// 2. Get List
@Test
public void getAll_Positive(){
    List<String> list = pengeluaranService.getAll();
    assertNotNull(list);
}
}