import com.summer.pojo.Student;
import com.summer.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        Student student1 = (Student) applicationContext.getBean("student1");

        System.out.println(student1.toString());
    }

    @Test
    public void testPmethod(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("userBeans.xml");
        User user1 =  applicationContext.getBean("user3", User.class);
        User user2 =  applicationContext.getBean("user3", User.class);
        System.out.println(user1 == user2);
    }
}
