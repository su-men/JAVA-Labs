package com.summer.mapper;

import com.summer.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    List<Department> queryDeptList();

    Department queryDeptById(Integer id);
}
