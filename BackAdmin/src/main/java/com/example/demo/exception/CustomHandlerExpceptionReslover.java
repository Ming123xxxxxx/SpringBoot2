package com.example.demo.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/19 10:19
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)//设置为最高优先级,因为自定义异常为最低优先级会被其他异常处理优先处理异常，也可以使用数字,数字越小,优先级越高
@Component
public class CustomHandlerExpceptionReslover implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(511,"我喜欢的错误");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
