package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/2/10 10:18
 */

public interface Person {
    String getName();
    Integer getAge();
}
