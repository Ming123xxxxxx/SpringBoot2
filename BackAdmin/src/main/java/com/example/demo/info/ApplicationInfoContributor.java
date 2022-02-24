package com.example.demo.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/2/7 10:38
 */
@Component
public class ApplicationInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("msg","你好").withDetail("hello","wend").withDetails(Collections.singletonMap("world","3333"));
    }
}
