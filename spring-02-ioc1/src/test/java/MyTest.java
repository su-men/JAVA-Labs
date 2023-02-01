import com.summer.dao.UserDao;
import com.summer.dao.UserDaoImpl;
import com.summer.dao.UserDaoMysqlImpl;
import com.summer.dao.UserDaoOracleImpl;
import com.summer.service.UserService;
import com.summer.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args){
        UserDao userDao = new UserDaoOracleImpl();

        //用户实际调用的Service层，而不会接触到Dao
        UserService userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        userService.getUser();
    }

}
