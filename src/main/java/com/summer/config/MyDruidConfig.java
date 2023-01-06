package com.summer.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import javax.sql.DataSource;
import java.util.HashMap;



@Configuration
public class MyDruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        HashMap<String, String> initParameters = new HashMap<>();

        //登录key是固定的，loginUsername,loginPassword
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁访问
        initParameters.put("allow","");

        bean.setInitParameters(initParameters);

        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();

        initParameters.put("exclusion","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return  bean;
    }
}
