import com.summer.config.ApplicationConfig;
import com.summer.mapper.UserMapper;
import com.summer.mapper.UserMapperImpl;
import com.summer.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Import(com.summer.config.ApplicationConfig.class)
public class MyTest {
    @Resource(name = "userMapper22")
    private UserMapper userMapper22;

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUser();

    for (User user : userList) {
      System.out.println(user);
      //
    }
    }

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
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserMapper userMapper = context.getBean("userMapper22", UserMapper.class);
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test4(){
        List<User> users = userMapper22.selectUser();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
