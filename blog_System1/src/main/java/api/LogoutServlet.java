package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null){
            //用户本来就没登录  谈不上注销  不过此处也没必要报错  直接跳转登陆页面即可
            resp.sendRedirect("login.html");
            return;
        }
        //uesr存在就删除了  不存在也没有副作用
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
    }
}
