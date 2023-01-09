package com.summer.dao;

import com.summer.pojo.Department;
import com.summer.pojo.Employee;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    @Resource
    private DepartmentDao departmentDao;

    private static Integer INDEX = 205;
    //模拟数据库中的数据
    private static final Map<Integer, Employee> employees;
    static{
        employees = new HashMap<>();
        employees.put(201,new Employee(201,"tom",1,"教学部","123456"));
        employees.put(202,new Employee(202,"tony",1,"市场部","123456"));
        employees.put(203,new Employee(203,"jemmy",1,"运营部","123456"));
        employees.put(204,new Employee(204,"kitty",0,"后勤部","123456"));
    }

    public Map<Integer,Employee> getEmployeesMap(){
        return employees;
    }

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void save(@NotNull Employee employee){
        if(employee.getId() == null){
            employee.setId(INDEX++);
        }

        employees.put(employee.getId(),employee);
    }

    public void deleteById(Integer id){
        if(id == null){
            return;
        }
        employees.remove(id);
    }
}
