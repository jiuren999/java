package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/edu_manage","root","123456");
			System.out.println("数据库连接成功");
			//创建执行环境
			Statement statement=conn.createStatement();
			//执行sql语句，得到结果集
			ResultSet result=statement.executeQuery("select * from class");
			while(result.next()) {
				System.out.print(result.getInt("classID")+" ");
				System.out.print(result.getString("className")+" ");
				System.out.println(result.getInt("majorID")+" ");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败");
			System.out.println("数据库连接失败");
		}
	}

}
