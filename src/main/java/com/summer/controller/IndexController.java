package com.summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在templates下的所有页面只能通过controller跳转
//需要thymeleaf的依赖
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(){
        return "test";
    }

    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("msg", "<h1>hello spring boot</h1>");

        model.addAttribute("users", Arrays.asList("123", "sdfdf"));

        return "test";
    }
}
