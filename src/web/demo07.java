package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo7")
public class demo07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //psot请求参数
        String username = request.getParameter("username");
//        System.out.println("post"+username);
        //获取数组
        String[] parameterValues = request.getParameterValues("hobby");
        for (String parameterValue : parameterValues) {
            System.out.println(parameterValue);
        }
        //获取参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);

        }
        System.out.println("**************************");

        //map
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //根据key获取
            String[] strings = parameterMap.get(name);
            System.out.println(name);
            for (String value : strings) {
                System.out.println(value);

            }
            System.out.println("___________________");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get请求参数
//        String username = request.getParameter("username");
//        System.out.println("get"+username);
        this.doPost(request, response);
    }
}
