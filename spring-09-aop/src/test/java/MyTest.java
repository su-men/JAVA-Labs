import com.summer.config.AopConfig;
import com.summer.config.LogConfig;
import com.summer.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
  @Test
  public void nameAOP() {
      //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

      ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
      UserService userService = context.getBean("userService", UserService.class);

      userService.add();


  }
}
