import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCselect {
    public static void main(String[] args) throws SQLException {
        //1.创建初始化数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java107?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");
        //2.建立连接
        Connection connection = dataSource.getConnection();
        //3.构造SQL
        String sql = "select *from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.执行SQL
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集和
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id="+ id + ", name= "+name );
        }

        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
