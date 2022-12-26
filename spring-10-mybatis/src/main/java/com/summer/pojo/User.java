package com.summer.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String loginName;
    private String userName;
    private String password;
    private String sex;
    private String email;
    private String address;
}
