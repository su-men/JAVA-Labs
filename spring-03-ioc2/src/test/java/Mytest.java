import com.summer.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        User user = (User)applicationContext.getBean("user");
        User user1 = (User)applicationContext.getBean("user1");
        User user2 = (User)applicationContext.getBean("user2");
        User user3 = (User)applicationContext.getBean("user3");

        user.show();
        user1.show();
        user2.show();
        user3.show();
    }
}
