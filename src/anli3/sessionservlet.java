package anli3;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

@WebServlet("/sessionservlet")
public class sessionservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        //获取session
        HttpSession session = request.getSession();
        String checkcode_serssion = (String) session.getAttribute("checkcode_serssion");
        //删除验证码session
        session.removeAttribute("checkcode_serssion");
        //先判断验证码是否正确
        if (checkcode_serssion != null && checkcode_serssion.equalsIgnoreCase(checkcode)) { //忽略大小写
            //判断其他
            if ("zhangsan".equals(username) && "123456".equals(password)) {
                //登陆成功
                //存储
                session.setAttribute("user",username);
                //重定向
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //存储数据
                request.setAttribute("login_error", "用户名或密码错误");
                //转发
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } else {
            //存储数据
            request.setAttribute("cc_error", "验证码错误");
            //转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
