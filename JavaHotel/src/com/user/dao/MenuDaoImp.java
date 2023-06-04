/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.db.DBCon;
import com.user.entity.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MenuDaoImp implements MenuDao{
    DBCon db = new DBCon();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<Menu> selectAll() {
         List<Menu> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            stmt = con.createStatement();
            String sql = "select * from tb_menu";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("有一行新纪录");   //uid 
                String mnum=rs.getString(1);
                String mname=rs.getString(2);
                String mcode=rs.getString(3);
                String munit=rs.getString(4);
                int munit_price=rs.getInt(5);
                int mnumber=rs.getInt(6);
                int mtotal=rs.getInt(7);
                
                Menu m = new Menu();
                m.setNum(mnum);
                m.setName(mname);
                m.setCode(mcode);
                m.setUnit(munit);
                m.setUnit_price(munit_price);              
                m.setCount(mnumber);
                m.setTotal(mtotal);
               
                list.add(m);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean delect(String num) {
        boolean flag = false;
        try {// 1、连接
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "delete from tb_menu where num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, num);
            int state = pstmt.executeUpdate();
            if (state > 0) {
                System.out.println("在dao中删除一行记录");
                flag = true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insert(Menu m) {
          boolean flag = true;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            //pstmt
            String sql = "insert into tb_menu(num,name,code,unit,unit_price,count,total) values(?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m.getNum());
            pstmt.setString(2, m.getName());
            pstmt.setString(3, m.getCode());
            pstmt.setString(4, m.getUnit());
            pstmt.setInt(5, m.getUnit_price());
            pstmt.setInt(6, m.getCount());
            pstmt.setInt(7, m.getTotal());
            
            int state = pstmt.executeUpdate();

            if (state > 0) {
                System.out.print("dao中插入用户成功");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public Menu selectByNum(String num) {
         Menu m = null;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "select * from tb_menu where num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();// 执行sql语句
            while (rs.next()) {
                System.out.println("有一行新纪录");
                String mnum=rs.getString(1);
                String mname=rs.getString(2);
                String mcode=rs.getString(3);
                String munit=rs.getString(4);
                int munit_price=rs.getInt(5);
                int mnumber=rs.getInt(6);
                int mmtotal=rs.getInt(7);
                
                m = new Menu();
                m.setNum(mnum);
                m.setName(mname);
                m.setCode(mcode);
                m.setUnit(munit);
                m.setUnit_price(munit_price);              
                m.setCount(mnumber);
                m.setTotal(mmtotal);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return m;
    }
    
}
