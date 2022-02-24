package com.example.bootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/14 10:38
 */
@Controller
public class VIewTestController {

    @GetMapping("/suc")
    public String success(Model model){
        //model中的数据会被放在请求域中，request.setAttribute("xx",xx);
        model.addAttribute("succ","Hello,Thymeleaf");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
