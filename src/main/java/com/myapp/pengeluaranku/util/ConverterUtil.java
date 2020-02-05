package com.myapp.pengeluaranku.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ConverterUtil{

    public static final String MONTH_FORMAT = "yyyy-MM";
    public static String convertStringTimeStampToStringDate(String timestamp){
        // convert String timestamp to long
        Long timelong = Long.parseLong(timestamp);
        Date date = new Date(timelong);
        SimpleDateFormat dateFormat = new SimpleDateFormat(MONTH_FORMAT);
        String newDate = dateFormat.format(date);
        
        return newDate;
    }
    public static Date convertStringTimeStampToDate(String timestamp){
        // convert String timestamp to long
        Long timelong = Long.parseLong(timestamp);
        Date date = new Date(timelong);
        
        return date;
    }
}