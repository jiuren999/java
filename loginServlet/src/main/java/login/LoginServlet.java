package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先从请求中拿到用户名和密码
        //保证读出来的参数也能支持中文
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //验证用户名密码是否正确
        if (username == null || password == null || username.equals("") || password.equals("")){
            resp.setContentType("text/html; charset = utf8");
            resp.getWriter().write("当前输入的用户名或者密码不能为空");
            return;
        }
        //此处就假定用户名只能是 zhangsan 和lisi  密码只能是 123
        //正常的登录逻辑,验证用户名密码都是从数据库读取的
        if (!username.equals("zhangsan" ) && !username.equals("lisi")){
            resp.setContentType("text/html ;charset=utf8");
            resp.getWriter().write("用户名或者密码有误");
            return;
        }
        if (!password.equals("123")){
            resp.setContentType("text/html ;charset=utf8");
            resp.getWriter().write("用户名或者密码有误");
            return;
        }

        //用户名和密码验证成功  接下来创建一个会话
        //当前用户处于未登陆的状态,此时请求的cookie中没有sessionId
        //所以此处的getSession是无法从服务器的哈希表中找到该对象
        //由于此处把参数设置为true了,所以就允许getSession再找不到对象的时候,创建新的session对象和sessionId
        //并且回自动把sessionId和session对象储存再哈希表中
        //同时返回这个Session对象,并在接下来的响应中会自动的把SessionID返回给客户端浏览器
        HttpSession session = req.getSession(true);
        //接下来可以让刚刚创建好的session对象存储咱们自定义的数据,就可以在这个对象中存储用户的身份信息
        session.setAttribute("username",username);
        //登陆成功之后,自动跳转到主页

        resp.sendRedirect("index");

    }
}
