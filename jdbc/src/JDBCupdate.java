import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCupdate {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java107?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");

        Connection connection = dataSource.getConnection();

        System.out.println("请输入你要修改id的姓名");
        String name = scanner.next();
        System.out.println("请输入你要修改的id");
        int id = scanner.nextInt();

        String sql ="update student set id=? where name=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);

        int ret = statement.executeUpdate();
        System.out.println("ret= "+ret);

        connection.close();
        statement.close();

    }
}
