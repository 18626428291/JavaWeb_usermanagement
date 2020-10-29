package download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.chrono.MinguoEra;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        //
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //
        FileInputStream fis = new FileInputStream(realPath);
        //
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
//        response.setHeader("content-type", mimeType);

        //
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);

        response.setHeader("content-disposition","attachment;filename="+filename);
        //
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] buff = new byte[1024 * 8];
        while ((len = fis.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        fis.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
