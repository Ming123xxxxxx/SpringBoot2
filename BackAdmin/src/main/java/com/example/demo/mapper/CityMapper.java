package com.example.demo.mapper;

import com.example.demo.bean.user_db;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/27 9:55
 */
public interface CityMapper {

    @Select("select * from user_db where user_id=#{id}")
    public user_db getById(int id);

    public void insertuser(user_db db);
}
