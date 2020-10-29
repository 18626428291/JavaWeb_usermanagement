package anli.Dao;

import anli.Util.JDBCUtils;
import anli.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作user表数据库
 */



public class UserDao {
    //声明 hdbctemplate对象公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



    /**
     *
     * @param loginUser
     * @return user包含用户全部数据
     */
    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
