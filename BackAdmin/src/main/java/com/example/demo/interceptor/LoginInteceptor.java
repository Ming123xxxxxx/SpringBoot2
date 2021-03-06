package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/16 10:15
 */

//登录检测
//1.配置好拦截器要拦截哪些请求
//2.把这些配置放在容器中
public class LoginInteceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            //放行
            return true;
        }
        //拦截住了，表示未登录，跳转到登录页
        request.setAttribute("massage","请先登录");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    //目标方法执行以后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //页面渲染以后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
