package com.example.CarSales.mapper;

import com.example.CarSales.model.dto.Request.RegistrRequest;
import com.example.CarSales.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",imports={LocalDateTime.class})
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    @Mapping(target = "createdAt",expression = "java(LocalDateTime.now())")
    User toUser(RegistrRequest registrRequest);

}
