package anli.Test;

import anli.Dao.UserDao;
import anli.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123456");
        //
        UserDao userDao = new UserDao();
        User loginuser = userDao.login(user);
        System.out.println(loginuser);
    }

}
