package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/2/10 10:22
 */
@Profile(value = {"test","default"})
@Data
@ConfigurationProperties("person")
@Component
public class Boss implements Person{

    private String name;
    private Integer age;
}
