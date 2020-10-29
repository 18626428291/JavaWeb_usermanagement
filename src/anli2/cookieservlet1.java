package anli2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 	2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 */
@WebServlet("/cookieservlet1")
public class cookieservlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //数据格式和编码
        response.setContentType("text/html;charset=utf-8");


        //1.获取cookie
        Cookie[] cookies = request.getCookies();
        //false表示没有cookie
        boolean flag = false;
        //遍历
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //获取名称
                String name = cookie.getName();
                //判断是不是lastname
                if ("lastname".equals(name)) {
                    flag = true;
                    //有cookie,不是第一次访问
                    //设置value
                    //获取当前时间的字符串
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String format = sdf.format(date);
                    //url编码
                    format = URLEncoder.encode(format, "utf-8");
                    //
                    cookie.setValue(format);
                    //持久化
                    cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
                    response.addCookie(cookie);
                    //响应
                    String value = cookie.getValue();
                    //url解码
                    value = URLDecoder.decode(format, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为" + value + "</h1>");
                    break;
                }

            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            //第一次访问
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//不编码空格报错
            String format = sdf.format(date);

            //url编码
            format = URLEncoder.encode(format, "utf-8");

            Cookie cookie = new Cookie("lastname", format);
            //持久化
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            response.addCookie(cookie);
            //响应
            response.getWriter().write("<h1>你好，欢迎首次登录</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
