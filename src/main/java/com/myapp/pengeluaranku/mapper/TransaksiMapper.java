package com.myapp.pengeluaranku.mapper;

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


}