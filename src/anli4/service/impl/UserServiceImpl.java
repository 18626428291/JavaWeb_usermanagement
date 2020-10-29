package anli4.service.impl;

import anli4.dao.UserDao;
import anli4.dao.impl.UserDaoImpl;
import anli4.domain.PageBean;
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

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
//        if (currentPage <= 0) {
//            currentPage = 1;
//        }


        //创建一个空的pagebean
        PageBean<User> pb = new PageBean<>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //dao查询list集合
        //需要传开始的记录索引
        int start = (currentPage - 1) * rows ;
        List<User> list =dao.findByPage(start, rows);
        pb.setList(list);
        //计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
