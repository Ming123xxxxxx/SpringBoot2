package com.example.demo.config;

import com.example.demo.interceptor.LoginInteceptor;
import com.example.demo.interceptor.RedisUrlCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/16 10:21
 */
//1.编写一个拦截器实现HandlerInterceptor接口
//2.拦截器注册到容器中(实现WebMvcConfigurer的addInterceptors)
//3.指定拦截规则【如果是拦截所有（addPathPatterns("/**"),则静态资源也会被拦截）】
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

//    @Autowired
//    RedisUrlCount redisUrlCount;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInteceptor())
                .addPathPatterns("/**")//此方式会导致所有请求都拦截,包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//放行此路径的请求,通过此方式放行登录页和静态资源

//        registry.addInterceptor(redisUrlCount)
//                .addPathPatterns("/**")//此方式会导致所有请求都拦截,包括静态资源
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
