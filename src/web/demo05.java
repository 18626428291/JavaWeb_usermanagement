package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo5")
public class demo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Enumeration<String> headers = request.getHeaderNames();
//        while (headers.hasMoreElements()) {
//            String name = headers.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name +":"+value);
//        }
        //获取user-agent
        String agent = request.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("chrome comming");
        } else if (agent.contains("Firefox")) {
            System.out.println("firefox comming");
        } else {
            System.out.println("1111");
        }
        //获取referer
        String referer = request.getHeader("referer");
        System.out.println(referer);
        //防盗链
        if (referer != null) {
            if (referer.contains("/login")) {
                System.out.println("播放。。。。。。");
            } else {
                System.out.println("非法网址");
            }
        }
    }
}
