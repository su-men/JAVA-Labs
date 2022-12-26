package com.summer.demo01;

public class HoseProxy {
    private Host host;

    public void setHost(Host host) {
        this.host = host;
    }

    public void rent(){
        seeHose();
        host.rent();
    }

    public void seeHose(){
        System.out.println("中介带看房子");
    }


}
