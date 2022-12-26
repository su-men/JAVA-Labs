import com.summer.demo01.HoseProxy;
import com.summer.demo01.Host;
import com.summer.demo02.UserService;
import com.summer.demo02.UserServiceImpl;
import com.summer.demo02.UserServiceLogProxy;
import org.junit.Test;

public class MyTest {
    public static void main(String[] args){

    }

    @Test
    public void testDemo01(){
        Host host = new Host();

        HoseProxy hoseProxy = new HoseProxy();
        hoseProxy.setHost(host);

        hoseProxy.rent();
    }

    @Test
    public void testDemo02(){
        UserServiceImpl userService  = new UserServiceImpl();
        UserServiceLogProxy proxy = new UserServiceLogProxy();
        proxy.setUserService(userService);

        proxy.add();
        proxy.delete();
    }
}
