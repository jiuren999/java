import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class p{
    public String username;
    public String password;
}

@WebServlet("/hello world")
public class HelloWorldServlet extends HttpServlet {
private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello world");
        resp.getWriter().write("hello");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这就是put");
        resp.setContentType("text/html; charset = utf8");
        resp.getWriter().write("我是put");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        p m = objectMapper.readValue(req.getInputStream(),p.class);
        System.out.println(m.password + m.username);
        resp.getWriter().write("ok");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dodelete");
        resp.setContentType("text/html; charset = utf8");
        resp.getWriter().write("这就是dodelte");
    }
}
