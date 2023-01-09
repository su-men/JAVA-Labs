package com.summer;

import com.summer.dao.EmployeeDao;
import com.summer.mapper.DeptMapper;
import com.summer.mapper.EmployeeMapper;
import com.summer.pojo.Department;
import com.summer.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@SpringBootTest
class Springboot01HellowordApplicationTests {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeDao employeeDao;


    @Test
    public void TestDept(){
        Department department = deptMapper.queryDeptById(101);
        System.out.println(department);

        List<Department> departments = deptMapper.queryDeptList();
        for(Department dept: departments){
            System.out.println(dept);
        }
    }

    @Test
    public void TestEmployee(){
        Collection<Employee> emps = employeeDao.getEmployees();
        for (Employee emp : emps) {
            employeeMapper.addEmployee(emp);
        }

        List<Employee> emps2 = employeeMapper.queryEmployeeList();
        for (Employee emp : emps2) {
            System.out.println(emp);
        }
    }

    @Test
    public void TestDeleteEmployee(){
        Employee employee = employeeMapper.queryEmployeeById(34);
        employee.setLastName("toooony");
        employeeMapper.updateEmployee(employee);
        List<Employee> emps2 = employeeMapper.queryEmployeeList();
        for (Employee emp : emps2) {
            System.out.println(emp);
        }
    }


    @Test
    public void TestDao(){
        Collection<Employee> emps = employeeDao.getEmployees();
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void TestEmployMap(){
        employeeMapper.addEmployeeMap(employeeDao.getEmployeesMap());
    }

    @Test
    public void TestEmployList(){
        List<Employee> employeeList = new ArrayList<Employee>(employeeDao.getEmployees());
        for (Employee e: employeeList) {
            System.out.println(e);
        }
        employeeMapper.addEmployeeList(employeeList);
    }
}
