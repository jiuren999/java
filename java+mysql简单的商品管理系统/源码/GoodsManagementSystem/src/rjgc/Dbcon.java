package rjgc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Dbcon {
	static String url="jdbc:mysql://localhost:3306/wtf?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";//数据库名为wtf
	static String username="root";//数据库用户名
	static String password="";//数据库密码 没有就是空字符串
	static Properties _prop=null;
	
	
	static {
		  _prop = new Properties();
		try {
			String proFilePath = System.getProperty("user.dir") + "\\config.properties";  
			InputStream in = new BufferedInputStream(new FileInputStream(proFilePath));  
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			_prop.load(bf);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public final static Connection getconnectin() {
		Connection con = null;// 连接数据库
		if(_prop.containsKey("database")) {				
			password=  _prop.getProperty("database");
		}
		if(_prop.containsKey("username")) {			
			username = _prop.getProperty("username");
		}
		if(_prop.containsKey("username")) {				
			password=  _prop.getProperty("password");
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 注册驱动
			con.setCatalog("wtf");// 选择要在其中进行工作的此 Connection对象数据库的子空间(wtf数据库)。
		} catch (SQLException sqle) {
			System.out.println(sqle + "连接错误");
		} catch (Exception e) {
			System.out.println(e + "其他错误");
		}
		return con;//返回Connection对象
	}

	// 添加数据
	public final static void insert(Connection con, Object obj[]) {
		PreparedStatement stmt = null;
		try {
			stmt = con
					.prepareStatement("insert into info(sno,sname,sprice) values(?,?,?)");
			// SQL 语句被预编译并存储在 PreparedStatement 对象中,包含多个 '?' IN 参数占位符的 SQL 语句
			stmt.setString(1, obj[0].toString());// 将指定参数设置为传入的字符串
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.execute(); // 执行sql语句
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "失败", "操作提示!",
					JOptionPane.NO_OPTION);
		}
	}

	// 查询数据
	public final static ResultSet query(Connection con) {
		ResultSet rs = null;
		PreparedStatement stmt = null;// sql语句执行对象
		try {
			stmt = con.prepareStatement("select * from info");// 将sql语句发送到数据库返回statement对象
			rs = stmt.executeQuery();// 执行 SQL 查询
			// stmt.close();// 不可关流
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;// 返回结果集
	}

	// 删除数据
	public final static int delete(Connection con, String s) {
		int num = 0;
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from info where sno=?");// ?待定通配符
			stmt.setObject(1, s);// 把第一个参数 即? 设置为传进来的String s
			num = stmt.executeUpdate();// 执行sql语句 '删除'功能无返回结果
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}