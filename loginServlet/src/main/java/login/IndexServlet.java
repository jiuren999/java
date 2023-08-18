package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//这个Servlet用来动态的生成主页面
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //此处禁止创建会话,如果没找到,认为i用户是未登录状态
        //如果找到了才认为是登录状态
        HttpSession session = req.getSession(false);
        if (session==null){
            resp.setContentType("text/html ;charset = utf8");
            resp.getWriter().write("该用户未登录");
            return;
        }
        String username = (String) session.getAttribute("username");
        if (username ==null){
            //虽然有会话对象,但是里面没有必要属性,也认为是异常登录状态
            resp.setContentType("text/html ;charset = utf8");
            resp.getWriter().write("该用户未登录");
            return;
        }

        //如果上述检查都OK 那就生成一个动态页面
        resp.setContentType("text/html;charset= utf8");
        resp.getWriter().write("欢迎你"+username);
    }
}
