package com.myapp.pengeluaranku.mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        injectionStrategy = CONSTRUCTOR,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = ALWAYS,
        nullValuePropertyMappingStrategy = IGNORE)
public interface UserMapper extends BaseMapper<User, UserReqVO>{
 UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
     

}