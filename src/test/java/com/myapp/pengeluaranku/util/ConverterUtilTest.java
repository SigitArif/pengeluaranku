package com.myapp.pengeluaranku.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConverterUtilTest{

@Test
public void convertSuccess(){
    String timestamp = "1580785493000";
    String expected ="2020-02";
    String actual = ConverterUtil.convertStringTimeStampToStringDate(timestamp);
    assertEquals(expected, actual);
}
}