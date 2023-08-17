import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Message{
    public String from;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
//    private List<Message> messageList = new LinkedList<Message>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过这个来处理获取所有信息
        //需要返回一个json字符串数组 .jackson直接帮我们处理好了格式
        List<Message> messageList = load();
        String respString = objectMapper.writeValueAsString(messageList);
        resp.setContentType("application/json; charset = utf8");
        resp.getWriter().write(respString);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过这个方法来处理"提交新消息"
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        save(message);
        System.out.println("消息提交成功 message="+message);
    }

    //这个方法用来查询数据库中的所有数据
    private List<Message> load() {
        List<Message> messageList = new ArrayList<Message>();
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");

        try {
            Connection connection = dataSource.getConnection();
            String sql = "select *from message";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");
                messageList.add(message);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    //这个方法用来往数据库中存一个数据
    private void save(Message message) {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");

        try {
            Connection connection = dataSource.getConnection();
            String sql = "insert into message values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,message.from);
            preparedStatement.setString(2,message.to);
            preparedStatement.setString(3,message.message);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
