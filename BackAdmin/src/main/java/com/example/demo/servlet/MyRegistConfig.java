package com.example.demo.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/20 9:39
 */
@Configuration(proxyBeanMethods = true)//proxyBeanMethods = true:保证依赖的组件始终是单实例的
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet servlet = new MyServlet();
        return new ServletRegistrationBean(servlet,"/my","/my2");//除了第一个参数，后面参数都是映射路径，可以写多个映射路径
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
       // return new FilterRegistrationBean(myFilter,myServlet());//拦截myServlet()返回的映射地址
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(myFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myLisener(){
        MyServletContextListen contextListen = new MyServletContextListen();
        return new ServletListenerRegistrationBean(contextListen);
    }
}
