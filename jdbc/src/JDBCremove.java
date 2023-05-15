import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCremove {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //1.创建初始化数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java107?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");
        //2.建立连接
        Connection connection = dataSource.getConnection();
        //3.构造SQL
        System.out.println("请输入你想要删除的学生id");
        int id = scanner.nextInt();
        String sql ="DELETE FROM student WHERE id=? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        //4.执行SQL
        int ret = statement.executeUpdate();
        System.out.println("ret= "+ret);
        //6.释放资源
        statement.close();
        connection.close();

    }
}
