package com.myapp.pengeluaranku.mapper;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;
import com.myapp.pengeluaranku.vo.PengeluaranResponseVO;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
injectionStrategy = InjectionStrategy.CONSTRUCTOR,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE,
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PengeluaranMapper extends BaseMapper<Pengeluaran, PengeluaranRequestVO, PengeluaranResponseVO>{
PengeluaranMapper INSTANCE = Mappers.getMapper(PengeluaranMapper.class);


}
