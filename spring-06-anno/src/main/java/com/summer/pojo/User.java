package com.summer.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 * @Component 等价于 <bean id="user" class="com.summer.pojo.User"/>
*/
@Component
//@Scope("singleton") 等价于 <bean scope="singleton"/>
@Scope("singleton")
public class User {
    //@Value("summer") 等价于<property name="name" value="summer"/>
    // @Value("summer")
    public String name;

    @Value("summer")
    public void setName(String name) {
        this.name = name;
    }
}
