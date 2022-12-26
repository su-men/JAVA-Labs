package com.summer.log;

public class AopLog {
    public void beforeLog(){
        System.out.println("AopLog.beforeLog");
    }

    public void afterLog(){
        System.out.println("AopLog.AfterLog");
    }
}
