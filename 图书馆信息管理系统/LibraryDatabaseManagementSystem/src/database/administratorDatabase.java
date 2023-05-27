package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class administratorDatabase {
	private static String connectionString = "jdbc:mysql://" + database_info.addressString
			+ ":" + database_info.portString +"/" + database_info.administrator_schema + "?serverTimezone=UTC";//连接字符
	
	private static Connection connection;//声明Connection对象
	private static Statement statement;//声明Statement类对象
	
	public static boolean connectResult = false;//描述连接结果
	
	/*安全的懒汉式单例模式*/
	private volatile static administratorDatabase instance = null;
	public static void Instantiate() {
		if (instance == null) {
			synchronized (administratorDatabase.class) {
				if (instance == null) {
					instance = new administratorDatabase();
				}
			}
		}
	}
	
	/*新建数据库连接*/
	public administratorDatabase() {
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
	
	public static String searchAdministratorDatabaseString(String accountString, String passwordString) {
		String SQL = "SELECT * FROM administrator_table WHERE administrator_account = " + accountString;
		try {
			ResultSet resultSet = statement.executeQuery(SQL);
			if(resultSet.next()) {
				if(resultSet.getString("administrator_password").equals(passwordString)) {
					String returnResultString = resultSet.getString("administrator_attribute");
					if(resultSet.getString("administrator_passwordQuestion") != null) {
						returnResultString = returnResultString + " " 
							+ resultSet.getString("administrator_passwordQuestion") + " " 
							+ resultSet.getString("administrator_passwordAnswer");
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
	
}