package com.summer.pojo;

public class User {
    private String name;
    private String id;
    private String password;

    public User(){
        System.out.println("User的无参构造");
    }

    public User(User user){
        this.name = user.name;
        this.id = user.id;
        this.password = user.password;
        System.out.println("User的有参构造1");
    }

    public User(String name,String id,String password){
        this.name = name;
        this.id = id;
        this.password = password;
        System.out.println("User的有参构造2");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
