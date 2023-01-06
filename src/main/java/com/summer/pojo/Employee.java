package com.summer.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String password;
    private Integer gender; // 0 girl, 1 boy

    private String department;
    private Date birth;

    public Employee(Integer id, String lastName, Integer gender, String department, String password) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
        this.password = password;
        this.birth = new Date();
    }
}
