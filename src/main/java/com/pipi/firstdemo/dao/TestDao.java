package com.pipi.firstdemo.dao;

import com.pipi.firstdemo.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestDao {
    @Select("select user_id userId,user_name userName,gender from test")
    List<User> getAllUsers();
}