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

@WebServlet("/finduserservlet")
public class Finduserservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        String id = request.getParameter("id");
        //
        UserService service = new UserServiceImpl();
        User userById = service.findUserById(id);
        //保存数据到request
        request.setAttribute("userbyid",userById);
        //转发
        request.getRequestDispatcher("/anli4page/update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
