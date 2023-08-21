package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

//通过这个类来实现一些后端提供的接口

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        if (blogId==null){
            List<Blog> blogs =blogDao.selectAll();
            String respString = objectMapper.writeValueAsString(blogs);
            resp.setContentType("application/json ;charset =utf8");
            resp.getWriter().write(respString);
        }else {
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            String respString = objectMapper.writeValueAsString(blog);
            resp.setContentType("application/json ;charset =utf8");
            resp.getWriter().write(respString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        //先从请求中拿到标题和正文
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || title.equals("") || content ==null || content.equals("")){
            String html = "<h3>title 或者 content 为空! 新增博客失败!</h3>";
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        //从会话中拿到作者的id
        HttpSession session  = req.getSession(false);
        if (session == null){
            String html = "<h3>当前用户未登录! 新增博客失败!</h3>";
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user ==null){
            String html = "<h3>当前用户未登录! 新增博客失败!</h3>";
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write(html);
            return;
        }
        //构造blog对象
        Blog blog = new Blog();
        blog.setUserId(user.getUserId());
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        // 4. 插入 blog 对象到数据库中
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
        // 5. 跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
