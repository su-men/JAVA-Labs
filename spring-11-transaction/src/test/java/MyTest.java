import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import summer.mapper.UserMapper;
import summer.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        List<User> users = userMapper.selectUser();

    for (User user : users) {
      System.out.println(user);
    }
    }

    @Test
    public void test3(){

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);

        userMapper.deleteUser(13);

    }
}
