package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.bean.t_f;
import com.example.demo.bean.user_db;
import com.example.demo.service.AccountService;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/14 11:04
 */
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("acct")
    public t_f getid(@RequestParam("id") int id){

        return accountService.getid(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public user_db citys(@RequestParam("id") int id){

        return cityService.citys(id);
    }

    @ResponseBody
    @GetMapping("insertus")
    public user_db save(user_db db){
        cityService.ins(db);
        return db;
    }

    @ResponseBody
    @GetMapping("sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from books", Long.class);
        return aLong.toString();
    }

    //登录页
    @GetMapping(value = {"/","/login"})
    public String loginPagge(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(!StringUtils.isEmpty(user.getUserName())&&"12345".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            //登录成功,重定向到main.html页面;重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("massage","账号密码错误");
            //登录失败,回到登陆页面
            return "login";
        }

    }

    //去main页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

//        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
//
//        String s = operations.get("/main.html");
//        String s1 = operations.get("/sql");
//        String s2 = operations.get("/dynamic_table");
//        String s3 = operations.get("/error");

//        model.addAttribute("s",s);
//        model.addAttribute("s1",s1);
//        model.addAttribute("s2",s2);
//        model.addAttribute("s3",s3);
        return "main";
    }
}
