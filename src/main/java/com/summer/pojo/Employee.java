package com.summer.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private Integer gender; // 0 girl, 1 boy

    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;

        this.birth = new Date();
    }
}
