package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/edu_manage","root","123456");
			System.out.println("���ݿ����ӳɹ�");
			//����ִ�л���
			Statement statement=conn.createStatement();
			//ִ��sql��䣬�õ������
			ResultSet result=statement.executeQuery("select * from class");
			while(result.next()) {
				System.out.print(result.getInt("classID")+" ");
				System.out.print(result.getString("className")+" ");
				System.out.println(result.getInt("majorID")+" ");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ��");
			System.out.println("���ݿ�����ʧ��");
		}
	}

}
