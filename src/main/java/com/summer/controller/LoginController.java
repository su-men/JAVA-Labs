package com.summer.controller;

import com.summer.mapper.EmployeeMapper;
import com.summer.pojo.Employee;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    EmployeeMapper employeeMapper;

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            Model model, HttpSession session){

        //具体业务
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            Employee employee = employeeMapper.queryEmployeeByName(username);
            System.out.println("employee====>" + employee);
            if(employee!=null && StringUtils.equals(password, employee.getPassword())){
                session.setAttribute("loginUser", username);
                session.setAttribute("emp", employee);
                return "redirect:/main.html";
            }
        }

        model.addAttribute("msg", "用户名或者密码错误");
        return "index";
    }
}
