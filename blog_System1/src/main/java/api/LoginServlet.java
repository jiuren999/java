package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        //从请求中获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || username.equals("") || password==null || password.equals("")){
            //用户名密码缺失  登陆必然失败
            String html = "<h3>登陆失败! 缺少用户名或者密码!</h3>";
            resp.setContentType("text/html;charset = utf8");
            resp.getWriter().write(html);
            return;
        }
        //从数据库中 看看这里得用户名和密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByName(username);
        if (user==null){
            //用户名不存在
            String html = "<h3>用户名或密码错误!</h3>";
            resp.setContentType("text/html;charset = utf8");
            resp.getWriter().write(html);
            return;
        }
        if (!password.equals(user.getPassword())){
            //密码错误
            String html = "<h3>用户名或密码错误!</h3>";
            resp.setContentType("text/html;charset = utf8");
            resp.getWriter().write(html);
            return;
        }
        //登录成功 需要设置会话
        //此处需要先创建一个会话
        HttpSession session = req.getSession(true);
        //此处就把用户对象存贮到session中了 ,下次用户访问其他页面,就可以直接拿到会话,进一步拿到之前的user对象了
        session.setAttribute("user",user);
        //返回一个重定向响应
        resp.sendRedirect("blog_list.html");
    }

//通过这个方法判断用户的登陆状态,已登陆返回200 ,未登录返回403
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //看当前请求是否已经存在会话,并且当前的会话是否包含user对象
        HttpSession session = req.getSession(false);
        if(session==null){
            //会话不存在 返回403  未登录状态
            resp.setStatus(403);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user==null){
            //虽然会话对象存在 ,但是用户对象没有 ,未登录状态
            resp.setStatus(403);
            return;
        }
        //已经登录
        //200是默认的状态码  此时不写也是可以的
        resp.setStatus(200);
        resp.setContentType("application/json;charset = utf8");
        user.setPassword("");  //避免把密码也返回给前端
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
