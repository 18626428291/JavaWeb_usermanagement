package web;

import javax.servlet.*;
import java.io.IOException;

public class demo01  implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet开始服务");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁了");

    }
}
