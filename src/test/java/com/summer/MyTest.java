package com.summer;

import com.summer.mapper.DeptMapper;
import com.summer.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class MyTest {
    @Resource
    private DeptMapper deptMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void TestDept(){
        deptMapper.queryDeptById(101);

    }

}
