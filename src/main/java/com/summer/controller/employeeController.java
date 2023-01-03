package com.summer.controller;

import com.summer.dao.DepartmentDao;
import com.summer.dao.EmployeeDao;
import com.summer.pojo.Department;
import com.summer.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;


@Controller
public class employeeController {
    @Resource
    EmployeeDao employeeDao;
    @Resource
    DepartmentDao departmentDao;

    @RequestMapping("/emps/list")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("emps", employees);
        return "/emps/list";
    }

    @GetMapping ("/emps/add")
    public String toAddPage(Model model){
        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "/emps/add";
    }

    @PostMapping("/emps/add")
    public String AddEmployee(Employee employee){
        //添加forward
        employeeDao.save(employee);
        return "redirect:/emps/list";
    }

    @GetMapping ("/emps/update")
    public String toUpdatePage(Integer id, Model model){
        System.out.println("update user Id ===> "+id);
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("departments", departments);
        model.addAttribute("emp", employee);

        return "/emps/update";
    }

    @PostMapping("/emps/update")
    public String UpdateEmployee(Employee employee){
        System.out.println("user employee ===> "+employee);
        employeeDao.save(employee);
        return "redirect:/emps/list";
    }

    @GetMapping("/emps/delete")
    public String DeleteEmployee(Integer id){
        System.out.println("delete user Id ===> "+id);
        employeeDao.deleteById(id);
        return "redirect:/emps/list";
    }
}
