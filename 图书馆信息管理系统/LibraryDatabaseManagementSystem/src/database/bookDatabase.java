package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import component.dateDeal;

public class bookDatabase {
	private static String connectionString = "jdbc:mysql://" + database_info.addressString
			+ ":" + database_info.portString +"/" + database_info.book_schema + "?serverTimezone=UTC";//连接字符
	
	private static Connection connection;//声明Connection对象
	private static Statement statement;//声明Statement类对象
	
	public static boolean connectResult = false;//描述连接结果
	
	private static String[] columnsNameString= {"book_number", "book_name", "book_writer", "book_publishingHouse",
			"book_publishingDate", "book_category", "book_callNumber", "book_floor", "bookrack", "book_state", 
			"book_readerNumber", "book_borrowDate", "book_renewDate", "book_returnDate"};
	
	/*安全的懒汉式单例模式*/
	private volatile static bookDatabase instance = null;
	public static void Instantiate() {
		if (instance == null) {
			synchronized (bookDatabase.class) {
				if (instance == null) {
					instance = new bookDatabase();
				}
			}
		}
	}
	
	/*新建数据库连接*/
	public bookDatabase() {
		try {
			Class.forName(database_info.driverString);//加载驱动程序 
			connection = DriverManager.getConnection(connectionString, database_info.userNameString, database_info.passwordString);//连接MySQL数据库
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//创建Statement类对象，用来执行SQL语句
			connectResult = true;//连接成功
		} catch (ClassNotFoundException e1) {	
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*查找书籍（全方式）*/
	public static String[][] searchBookString(String SQL){
		try {
			ResultSet resultSet = statement.executeQuery(SQL);
			int rowCountSum = 0;
			while(resultSet.next()) {
				rowCountSum++;
			}
			if(rowCountSum == 0) {
				return null;
			}else {
				String[][] searchResult = new String[rowCountSum][14];
				resultSet.beforeFirst();
				int rowCountIndex = 0;
				while(resultSet.next()) {
					for(int i = 0; i < columnsNameString.length; i++) {
						searchResult[rowCountIndex][i] = resultSet.getString(columnsNameString[i]);
					}	
					rowCountIndex++;
				}
				return searchResult;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*借阅书籍*/
	public static void borrowBookVoid(String book_readerNumber, String book_number){
		String book_borrowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		book_borrowDate = book_borrowDate.substring(2, 4) + book_borrowDate.substring(5, 7) + book_borrowDate.substring(8);
		String book_returnDate = dateDeal.dateAdd(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), 30);
		book_returnDate = book_returnDate.substring(2, 4) + book_returnDate.substring(5, 7) + book_returnDate.substring(8);
		String SQL = "UPDATE book_table SET book_state = '已借', book_readerNumber = " + book_readerNumber + ", book_borrowDate = " + book_borrowDate
				+ ", book_returnDate = " + book_returnDate + " WHERE book_number = '" + book_number + "'";
		try {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*归还书籍*/
	public static void returnBookVoid(String book_readerNumber, String book_number){
		String SQL = "UPDATE book_table SET book_state = '可借', book_readerNumber = null, book_borrowDate = "
				+ "null, book_returnDate = null WHERE book_number = '" + book_number + "'";
		try {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
