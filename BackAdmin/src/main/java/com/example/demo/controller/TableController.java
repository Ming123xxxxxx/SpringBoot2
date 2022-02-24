package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.UsInfo;
import com.example.demo.bean.User;
import com.example.demo.exception.UserManyException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/15 9:16
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String bastable(@RequestParam("a") String a){
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dytable(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){

//        查询所有数据
        List<UsInfo> list = userService.list();
//        model.addAttribute("users",list);
        //从user表中查询数据

        //分页查询数据
        Page<UsInfo> userPage= new Page<UsInfo>(pn,2);

        //分页查询的结果
        Page<UsInfo> page = userService.page(userPage,null);

        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String restable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String edtable(){
        return "table/editable_table";
    }
}
