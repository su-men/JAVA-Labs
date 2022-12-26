package com.summer.config;

import com.summer.mapper.UserMapperImpl;
import com.summer.mapper.UserMapperImpl2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import java.util.Objects;

//@Import(com.summer.config.MybatisDaoConfig.class)
@Configuration
public class ApplicationConfig {

    @Configuration
    public static class MybatisDaoConfig {
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
    }



    //问题1：
    // 为什么配置类之间可以用过@Resource装配的方式引用Beans
    // 但是在业务类中只能通过AnnotationConfigApplicationContext方式装配
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;




    @Bean(name = "userMapper")
    UserMapperImpl userMapper(){
       UserMapperImpl userMapper =  new UserMapperImpl();
       userMapper.setSqlSession(sqlSession);
       return userMapper;
    }

    @Bean(name = "userMapper2")
    UserMapperImpl2 userMapper2(){
        UserMapperImpl2 userMapper2 = new UserMapperImpl2();
        userMapper2.setSqlSessionFactory(sqlSessionFactory);
        return userMapper2;
    }

    //问题2：
    //为甚么 s 可以自动装配，它是怎么知道要注入sqlSessionFactory的
    @Bean(name = "userMapper22")
    UserMapperImpl2 userMapper22(SqlSessionFactory s){
        UserMapperImpl2 userMapper2 = new UserMapperImpl2();
        userMapper2.setSqlSessionFactory(s);
        //System.out.println(s == sqlSessionFactory);
        return userMapper2;
    }
}
