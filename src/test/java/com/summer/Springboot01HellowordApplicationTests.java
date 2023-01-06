package com.summer;

import com.summer.dao.EmployeeDao;
import com.summer.mapper.DeptMapper;
import com.summer.mapper.EmployeeMapper;
import com.summer.pojo.Department;
import com.summer.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
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
        employeeMapper.addEmployee(employeeDao.getEmployeeById(201));

        List<Employee> emps = employeeMapper.queryEmployeeList();
        for (Employee emp : emps) {
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

}
