package anli4.service.impl;

import anli4.dao.UserDao;
import anli4.dao.impl.UserDaoImpl;
import anli4.domain.User;
import anli4.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelectUser(String[] values) {
        if (values != null && values.length > 0) {
            for (String id : values) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }
}
