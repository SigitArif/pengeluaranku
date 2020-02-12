package com.myapp.pengeluaranku.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.myapp.pengeluaranku.vo.RangeTimeVO;

import org.springframework.stereotype.Component;

@Component
public class ConverterUtil {

    public static final String MONTH_FORMAT = "yyyy-MM";

    public static String convertStringTimeStampToStringDate(String timestamp) {
        // convert String timestamp to long
        Long timelong = Long.parseLong(timestamp);
        Date date = new Date(timelong);
        SimpleDateFormat dateFormat = new SimpleDateFormat(MONTH_FORMAT);
        String newDate = dateFormat.format(date);

        return newDate;
    }

    public static Date convertStringTimeStampToDate(String timestamp) {
        // convert String timestamp to long
        Long timelong = Long.parseLong(timestamp);
        Date date = new Date(timelong);

        return date;
    }

    public static RangeTimeVO convertMonthToDateRange(String month) throws ParseException {
        String start = month.concat("-01");
        Calendar cal = Calendar.getInstance();
        String[] ymd = start.split("-");
        int y = Integer.parseInt(ymd[0]);
        int m = Integer.parseInt(ymd[1]);
        int d = Integer.parseInt(ymd[2]);
        cal.set(y, m, d);
        int maxDayOfMonth = cal.getMaximum(Calendar.DATE);
        String end = month.concat("-"+String.valueOf(maxDayOfMonth));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = dateFormat.parse(start);
        Date endTime = dateFormat.parse(end);

        RangeTimeVO range = new RangeTimeVO();
        range.setStartTime(startTime);
        range.setEndTime(endTime);

        return range;
    }


}