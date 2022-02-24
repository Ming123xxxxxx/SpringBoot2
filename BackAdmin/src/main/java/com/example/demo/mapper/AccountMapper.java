package com.example.demo.mapper;

import com.example.demo.bean.t_f;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/26 11:44
 */
public interface AccountMapper {

   public t_f gettf(int id);
}
