package anli.web.servlet;

import anli.Dao.UserDao;
import anli.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        //封装user对象
//        User loginuser = new User();
//        loginuser.setUsername(username);
//        loginuser.setPassword(password);

        //获取所有参数
        Map<String, String[]> map = request.getParameterMap();
        //创建user对象
        User loginuser = new User();
        //使用beanutils封装对象
        try {
            BeanUtils.populate(loginuser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用userdao
        UserDao userdao = new UserDao();
        User user = userdao.login(loginuser);
        if (user == null) {
            //登陆失败
            request.getRequestDispatcher("/FailServlet").forward(request,response);

        } else {
            //登陆成功
            request.setAttribute("user", user);
            request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
