/*package com.summer.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Objects;

@Configuration
public class MybatisDaoConfig {
    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db_login?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql123456");

        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    SqlSessionFactoryBean sqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-spring-config.xml"));
        sqlSessionFactory.setMapperLocations(new ClassPathResource("com/summer/mapper/UserMapper.xml"));

        return sqlSessionFactory;
    }

    @Bean(name = "sqlSession")
    SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(Objects.requireNonNull(sqlSessionFactory().getObject()));
    }
}*/
