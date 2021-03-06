package anli4.web.servlet;

import anli4.domain.PageBean;
import anli4.domain.User;
import anli4.service.UserService;
import anli4.service.impl.UserServiceImpl;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";

        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
<<<<<<< HEAD
        //获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();
=======
>>>>>>> 7b4d72ead3f12e7392a6626953c3ba46a4769f4b
        //调用service
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows);
        //存入request
        request.setAttribute("pb", pb);
        //转发
        request.getRequestDispatcher("/anli4page/list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
