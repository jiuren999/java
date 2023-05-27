package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class readerDatabase {
	private static String connectionString = "jdbc:mysql://" + database_info.addressString
			+ ":" + database_info.portString +"/" + database_info.reader_schema + "?serverTimezone=UTC";//连接字符
	
	private static Connection connection;//声明Connection对象
	private static Statement statement;//声明Statement类对象
	
	public static boolean connectResult = false;//描述连接结果
	
	/*安全的懒汉式单例模式*/
	private volatile static readerDatabase instance = null;
	public static void Instantiate() {
		if (instance == null) {
			synchronized (readerDatabase.class) {
				if (instance == null) {
					instance = new readerDatabase();
				}
			}
		}
	}
	
	/*新建数据库连接*/
	public readerDatabase() {
		try {
			Class.forName(database_info.driverString);//加载驱动程序 
			connection = DriverManager.getConnection(connectionString, database_info.userNameString, database_info.passwordString);//连接MySQL数据库
			statement = connection.createStatement();//创建Statement类对象，用来执行SQL语句
			connectResult = true;//连接成功
		} catch (ClassNotFoundException e1) {	
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*用户登录查找*/
	public static String searchReaderDatabaseString(String accountString, String passwordString) {
		String SQL = "SELECT * FROM reader_total_table WHERE reader_number = " + accountString;
		try {
			ResultSet resultSet = statement.executeQuery(SQL);
			if(resultSet.next()) {
				if(resultSet.getString("reader_password").equals(passwordString)) {
					String returnResultString = resultSet.getString("reader_name") + " "
							+ resultSet.getString("reader_state") + " "
							+ resultSet.getString("borrow_maxNum") + " "
							+ resultSet.getString("borrow_num");
					if(resultSet.getString("borrow_bookNumbers") != null) {
						returnResultString = returnResultString + " " 
								+ resultSet.getString("borrow_bookNumbers");
					}
					resultSet.close();
					return returnResultString;//密码正确
				}else {
					resultSet.close();
					return "2";//密码错误
				}				
			}else {
				resultSet.close();
				return "0";//未查到该账户，该账户不存在
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "-1";//数据库连接错误
		}
	}
	
	/*管理员查找用户*/
	public static String searchReaderDatabaseString(String accountString) {
		String SQL = "SELECT * FROM reader_total_table WHERE reader_number = " + accountString;
		try {
			ResultSet resultSet = statement.executeQuery(SQL);
			if(resultSet.next()) {
				String returnResultString = resultSet.getString("reader_name") + " "
						+ resultSet.getString("reader_state") + " "
						+ resultSet.getString("borrow_maxNum") + " "
						+ resultSet.getString("borrow_num");
				if(resultSet.getString("borrow_bookNumbers") != null) {
					returnResultString = returnResultString + " " 
						+ resultSet.getString("borrow_bookNumbers");
				}
				resultSet.close();
				return returnResultString;		
			}else {
				resultSet.close();
				return "0";//未查到该账户，该账户不存在
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "-1";//数据库连接错误
		}
	}
	
	/*借阅书籍*/
	public static void borrowBookVoid(String book_readerNumber, String borrow_num, String borrow_bookNumbers){
		String SQL = "UPDATE reader_total_table SET borrow_num = " + borrow_num + ", borrow_bookNumbers = '" + borrow_bookNumbers + "' WHERE reader_number = '" + book_readerNumber + "'";
		try {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*归还书籍*/
	public static void returnBookVoid(String book_readerNumber, String borrow_num, String borrow_bookNumbers){
		String SQL = "UPDATE reader_total_table SET borrow_num = " + borrow_num + ", borrow_bookNumbers = '" + borrow_bookNumbers + "' WHERE reader_number = '" + book_readerNumber + "'";
		try {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}