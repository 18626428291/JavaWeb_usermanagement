package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebServlet(urlPatterns = "/demo2")
//@webServlet(value = "/demo2")
@WebServlet("/demo2")
public class demo02 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet 3.0 来了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
