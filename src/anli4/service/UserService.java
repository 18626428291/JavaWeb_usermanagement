package anli4.service;

import anli4.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    User login(User user);


    void addUser(User user);

    void deleteUser(String id);


    User findUserById(String id);

    void update(User user);

    void deleteSelectUser(String[] values);
}
