package com.summer.dao;

import com.summer.pojo.Department;
import com.summer.pojo.Employee;
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
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(201,new Employee(201,"tom",1,new Department(101,"教学部")));
        employees.put(202,new Employee(202,"tony",1,new Department(101,"教学部")));
        employees.put(203,new Employee(203,"jemmy",1,new Department(101,"教学部")));
    }

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
}
