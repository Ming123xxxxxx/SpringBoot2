package com.example.demo;

import com.example.demo.bean.UsInfo;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from books", Long.class);
        log.info("记录数="+aLong);
        log.info("数据源类型="+ dataSource.getClass());
    }

    @Test
    public void testuserinfo(){

        UsInfo usInfo = userMapper.selectById(1);
        log.info("用户信息="+usInfo.toString());
    }

//    @Test
//    public void JedisTest(){
//        ValueOperations<String,String> operations = redisTemplate.opsForValue();
//        operations.set("hello3","linux");
//        System.out.println("获取="+operations.get("hello3"));
//    }


}
