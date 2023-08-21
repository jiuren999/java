package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        //先读取出blogId
        String blogId = req.getParameter("blogId");
        if (blogId==null || blogId.equals("")){
            //直接返回userID为0得对象  因为最终返回的是一个json数据
            //此处也是返回json格式比较好 如果返回一个html ,前端处理就要麻烦
            String respJson = objectMapper.writeValueAsString(new User());
            resp.getWriter().write(respJson);
            System.out.println("参数给定的blogId为空");
            return;
        }
        //查询数据库  查询对应的blog对象
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if (blog == null){
            String respJson = objectMapper.writeValueAsString(new User());
            resp.getWriter().write(respJson);
            System.out.println("参数给定的blogId为不存在");
            return;
        }
        //根据blog中的userId  查询作者信息
        UserDao userDao = new UserDao();
        User user= userDao.selectUserById(blog.getUserId());
        if (user==null){
            String respJson = objectMapper.writeValueAsString(new User());
            resp.getWriter().write(respJson);
            System.out.println("该博客对应的作者不存在!");
            return;
        }
        //user对象查到了  返回即可
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
