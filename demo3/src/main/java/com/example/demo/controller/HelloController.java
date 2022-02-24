package com.example.demo.controller;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/2/10 10:02
 */
@RestController
public class HelloController {

    //若是找不到配置文件中的相关属性,则name为李四
    @Value("${person.name:李四}")
    private String name;

    @Autowired
    private Person person;

    @GetMapping("/")
    public Person hello(){
        return person;
    }
}
