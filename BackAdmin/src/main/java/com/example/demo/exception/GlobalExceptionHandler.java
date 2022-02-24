package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/19 9:12
 */

//处理整个web的controller异常
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(
            value = {ArithmeticException.class,NullPointerException.class}
            )//处理异常,value中的属性为此方法处理的异常类型
    public String handlerArithException(Exception e){

      log.error("异常是:"+e);
        return "login";//返回视图地址
    }
}
