package com.example.demo.service;

import com.example.demo.bean.user_db;
import com.example.demo.mapper.CityMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/27 9:58
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;
    Counter counter;

    public void Citys(MeterRegistry meterRegistry){
         counter = meterRegistry.counter("cityService.saveCity.count");
    }

    public user_db citys(int id){
        return cityMapper.getById(id);
    }

    public void ins(user_db db){
        counter.increment();
        cityMapper.insertuser(db);
    }
}
