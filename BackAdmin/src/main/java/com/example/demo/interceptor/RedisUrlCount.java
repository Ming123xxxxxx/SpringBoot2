package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/29 11:40
 */
//@Component
public class RedisUrlCount
//        implements HandlerInterceptor
{

//    @Autowired
//    StringRedisTemplate redisTemplate;

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
//        //默认每次访问当前uri就会计数+1
//        redisTemplate.opsForValue().increment(uri);
//        return true;
//    }
}
