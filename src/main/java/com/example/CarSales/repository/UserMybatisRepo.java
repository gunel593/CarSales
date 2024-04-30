package com.example.CarSales.repository;

import com.example.CarSales.model.entity.Car;
import com.example.CarSales.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMybatisRepo {
    void insert(User user);
     Optional<User> findByUsername(@Param("username") String username);

}
