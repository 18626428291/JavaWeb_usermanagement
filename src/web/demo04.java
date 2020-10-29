package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo4")
public class demo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求方式
        String method = request.getMethod();
        System.out.println(method);
        //虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //请求uri
        String requestURI = request.getRequestURI();
        //请求url
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        //协议、版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //ip地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
