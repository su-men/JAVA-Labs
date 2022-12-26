package com.summer.demo02;


/* 静态代理
 *
 */
public class UserServiceLogProxy {
    UserServiceImpl userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add(){
        log();
        userService.add();
    }

    public void delete(){
        log();
        userService.delete();
    }

    public void update(){
        log();
        userService.update();
    }

    public void query(){
        log();
        userService.query();
    }

    protected void log(){
        String methodName= new Throwable().getStackTrace()[1].getMethodName();
        System.out.println("[debug]" + methodName + "被调用!");
    }
}
