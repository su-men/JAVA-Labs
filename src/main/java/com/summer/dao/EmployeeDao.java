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
    private static Map<Integer, Employee> employees = null;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(201,new Employee(201,"tom",1,new Department(101,"教学部")));
        employees.put(202,new Employee(202,"tony",1,new Department(102,"市场部")));
        employees.put(203,new Employee(203,"jemmy",1,new Department(103,"运营部")));
        employees.put(204,new Employee(204,"kitty",0,new Department(104,"后勤部")));
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

        Department dept = departmentDao.getDepartmentById(employee.getDepartment().getId());
        employee.setDepartment(dept);
        employees.put(employee.getId(),employee);
    }

    public void deleteById(Integer id){
        if(id == null){
            return;
        }
        employees.remove(id);
    }
}
