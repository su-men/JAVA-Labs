package com.summer.demo01;

import com.summer.demo01.Host;
import com.summer.demo01.ProxyInvocationHandler;
import com.summer.demo01.Rent;
import org.junit.Test;

public class client {
    @Test
    public  void  test1(){
        //真实角色
        Host host = new Host();
        //代理角色：现在没有
       ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //
        proxyInvocationHandler.setRent(host);

        Rent proxy = (Rent)proxyInvocationHandler.getProxy();

        proxy.rent();
    }

    @Test
    public void test2(){
        Host host = new Host();
        HoseProxy proxy = new HoseProxy();

        proxy.setHost(host);

        proxy.rent();
    }
}
