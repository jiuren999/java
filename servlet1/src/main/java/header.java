import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/header")
public class header extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset = utf8");
        Date now = new Date();
        resp.setHeader("Refresh","1");
//        resp.getWriter().write("time="+System.currentTimeMillis());
        SimpleDateFormat CeshiFmt3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        resp.getWriter().write("time ="+CeshiFmt3.format(now));
    }
}
