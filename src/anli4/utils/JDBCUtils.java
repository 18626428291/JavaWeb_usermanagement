package anli4.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc,使用durid连接池
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //加载配置文件
            Properties prop = new Properties();
            //使用classloader加载配置文件，获取字节输入流
            InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(input);
            //初始化连接池
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    //获取链接池对象
    public static DataSource getDataSource() {
        return ds;
    }


    //获取链接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }





}
