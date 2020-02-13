package com.myapp.pengeluaranku.mapper;

import java.text.SimpleDateFormat;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.domain.Transaksi;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;
import com.myapp.pengeluaranku.vo.PengeluaranResponseVO;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;
import com.myapp.pengeluaranku.vo.TransaksiResVO;

import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
injectionStrategy = InjectionStrategy.CONSTRUCTOR,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE,
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TransaksiMapper extends BaseMapper<Transaksi, TransaksiReqVO, TransaksiResVO>{
TransaksiMapper INSTANCE = Mappers.getMapper(TransaksiMapper.class);

@Mapping(target = "name", expression = "java(model.getPengeluaran().getName())")
TransaksiResVO toVO(Transaksi model);
@AfterMapping
default void setTrxDate(@MappingTarget TransaksiResVO vo, Transaksi model) {
    String pattern = "dd/MM/yyyy";
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    String trxDate = dateFormat.format(model.getTrxDate());
    vo.setTanggalTransaksi(trxDate);
}


}