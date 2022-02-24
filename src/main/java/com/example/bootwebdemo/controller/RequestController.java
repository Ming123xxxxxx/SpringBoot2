package com.example.bootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/10 11:49
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("masseage","成功了...");
        request.setAttribute("code",200);
        return "forward:success";//转发到/success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("masseage") String masseage,
                                       @RequestAttribute("code") Integer code,
                                       HttpServletRequest request){

        Object masseage1 = request.getAttribute("masseage");
        Map<String,Object> map=new HashMap<>();
        map.put("reqyestMethod_masseage",masseage1);
        map.put("annotation_masseage",masseage);
        return map;
    }

}
