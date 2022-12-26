package summer.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import summer.pojo.User;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> selectUser() {
        User user = new User(13,"","","","1","","");

        addUser(user);
        deleteUser(13);

        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
