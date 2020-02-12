package com.myapp.pengeluaranku.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class RangeTimeVO{

    private Date startTime;
    private Date endTime;
    public RangeTimeVO(){}
}