package anli4.web.servlet;

import anli4.domain.User;
import anli4.service.UserService;
import anli4.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        //users存入request域
        request.setAttribute("users",users);
        //转发
        request.getRequestDispatcher("/anli4page/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
