package com.summer.mapper;


import com.summer.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EmployeeMapper {
    List<Employee> queryEmployeeList();

    Employee queryEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void addEmployeeMap(@Param("employMap") Map<Integer, Employee> employeeMap);

}
