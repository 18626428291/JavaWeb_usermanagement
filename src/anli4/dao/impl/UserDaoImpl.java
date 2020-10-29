package anli4.dao.impl;

import anli4.dao.UserDao;
import anli4.domain.User;
import anli4.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用jdbc操作数据库
        //定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEamil());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        //
        template.update(sql, id);

    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq =? ,eamil = ? where id =?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEamil(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String,String[]> map) {
        //定义一个模板sql
        String sql = "select count(*) from user where 1 = 1 ";
        //
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = map.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = map.get(key)[0];//只获取第一个
            //判断是否null
            if (value != null && !"".equals(value)) {
                //
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//条件的值
            }

        }

        //
        System.out.println(sql);
        System.out.println(params);
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String,String[]> map) {
        String sql = "select * from user where 1=1 ";
        //
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = map.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = map.get(key)[0];//只获取第一个
            //判断是否null
            if (value != null && !"".equals(value)) {
                //
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//条件的值
            }

        }
        //添加分页查询
        sb.append(" limit ? , ? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        //
        System.out.println(sql);
        System.out.println(params);



        return template.query(sql, new BeanPropertyRowMapper<>(User.class), params.toArray());
    }
}
