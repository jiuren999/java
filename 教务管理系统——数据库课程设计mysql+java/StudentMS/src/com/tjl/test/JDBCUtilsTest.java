package com.tjl.test;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.jdbc.JDBCUtils;

public class JDBCUtilsTest {


	public void jdbcConnectionTest() throws Exception {
		Connection conn=JDBCUtils.getConnection();
		Statement statement=conn.createStatement();
		ResultSet result=statement.executeQuery("select * from class");
		while(result.next()) {
			System.out.print(result.getInt("classID")+" ");
			System.out.println(result.getString("className")+" ");
			//System.out.println(result.getInt("majorID")+" ");
		}
	}
	//���Ե�¼
	

	public void loginTest() throws Exception {
		UserDao_Imp userDao_Imp =new UserDao_Imp();
		User user = new User("admin","admin");
		int type = userDao_Imp.login(user);
		System.out.println(type);
	}
	
	//��������û�

	public void insertTest() throws Exception {
		UserDao_Imp userDao_Imp =new UserDao_Imp();
		User user = new User("������","yml");
		boolean flag = userDao_Imp.insert(user);
		System.out.println(flag);
	}
	
	//����ɾ���û�

	public void deleteTest() throws Exception {
		UserDao_Imp userDao_Imp =new UserDao_Imp();
		User user = new User("������","yml");
		boolean flag = userDao_Imp.delete(user.getUname());
		System.out.println(flag);
	}
	//�����޸��û�

	public void updateTest() throws Exception {
		UserDao_Imp userDao_Imp =new UserDao_Imp();
		User user = new User("������","syg");
		boolean flag = userDao_Imp.update(user);
		System.out.println(flag);
	}
	//���Բ�ѯ�û�

		public void selectTest() throws Exception {
			UserDao_Imp userDao_Imp =new UserDao_Imp();
			User user = new User("������","syg");
			User user1 = userDao_Imp.select(user.getUname());
			System.out.println(user1);
		}
	
}
