package anli4.web.servlet;

import anli4.domain.User;
import anli4.service.UserService;
import anli4.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/adminloginServlet")
public class AdminloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String verifycode = request.getParameter("verifycode");//用户填写的验证码
        //验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//保证验证码一次性
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
           //不正确
            request.setAttribute("login_msg","验证码输入错误!");
            request.getRequestDispatcher("/anli4page/login.jsp").forward(request,response);
            return;
        }
        //正确
        //获取map
        Map<String, String[]> map = request.getParameterMap();
        //封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service查询
        UserService userService = new UserServiceImpl();
        User loginuser = userService.login(user);
        //判断是否成功
        if (loginuser != null) {
            //成功
            //用户存入session
            session.setAttribute("user", loginuser);
            //跳转
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
            //失败
            request.setAttribute("login_msg","用户名或密码输入错误!");
            request.getRequestDispatcher("/anli4page/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
