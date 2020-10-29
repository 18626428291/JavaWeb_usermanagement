package anli3;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkcode")
public class checkcode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码
        //创建一个对象,内存中画图
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //美化图片
        //填充
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, width, height);
        //
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);
        //
        String str = "AbcddahkwnlcxawnkcjsnubeuBCEKUNBCKJNASJNAKLCJN";
        Random ran = new Random();
        //
        StringBuilder std = new StringBuilder();
        for (int i = 1; i <=4 ; i++) {
            int index = ran.nextInt(str.length());
            char c = str.charAt(index);
            std.append(c);

            //
            graphics.drawString(c+"", width/5*i, height/2);

        }
        //
        String checkcode_serssion = std.toString();
        //存入session
        request.getSession().setAttribute("checkcode_serssion",checkcode_serssion);

        graphics.setColor(Color.GREEN);

        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2= ran.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }


        //图片输出页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
