import com.fasterxml.jackson.databind.ObjectMapper;
import sun.plugin2.message.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Message1{
    public String from;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "love{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Message1> message1List = new ArrayList<Message1>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过这个方法来处理所有留言信息
        //需要返回一个json字符串数组  jackson直接帮我们处理好了格式
        String respString = objectMapper.writeValueAsString(message1List);
        resp.setContentType("text/html;charset = utf8");
        resp.getWriter().write(respString);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Message1 message = objectMapper.readValue(req.getInputStream(),Message1.class);
        message1List.add(message);
        System.out.println("消息提交成功! message="+message);
    }
}
