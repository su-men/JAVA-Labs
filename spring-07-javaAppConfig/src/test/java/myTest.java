import com.summer.config.UserConfig;
import com.summer.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class myTest {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        User user1 = context.getBean("user1",User.class);
        User user2 = context.getBean("user1",User.class);
        User user3 = context.getBean("user2",User.class);
        System.out.println(user3);
        System.out.println(user2 == user1);
    }
}
