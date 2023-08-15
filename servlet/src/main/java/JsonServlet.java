import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class User{
    public String username;
    public String password;
}
@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    //使用json最核心的对象就是ObjectMapper
    //通过这个对象,就可以把json字符串解析成java对象,也可以把一个java对象解析成json字符串
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过post请求的body传递过来一个json格式的字符串
        User user = objectMapper.readValue(req.getInputStream(),User.class);

        System.out.println("password="+user.password+"username = "+user.username);
        resp.getWriter().write("ok");
    }
}
