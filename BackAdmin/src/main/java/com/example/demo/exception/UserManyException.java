package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/19 9:30
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")//value为错误时返回的状态码,FORBIDDEN为403,reason为原因
public class UserManyException extends RuntimeException{

    public UserManyException(){

    }

    public UserManyException(String message){
        super(message);
    }
}
