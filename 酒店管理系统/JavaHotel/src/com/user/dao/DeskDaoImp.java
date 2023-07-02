/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.db.DBCon;
import com.user.entity.Desk;
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
public class DeskDaoImp implements  DeskDao{
    DBCon db = new DBCon();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<Desk> selectAll() {
        List<Desk> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            stmt = con.createStatement();
            String sql = "select * from tb_desk";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("有一行新纪录");   //uid 
                String mname=rs.getString(1);
                int msid=rs.getInt(2);
                
                Desk d = new Desk();
                d.setNum(mname);
                d.setSeating(msid);

                list.add(d);
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
            String sql = "delete from tb_desk where num=?";
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
    public boolean insert(Desk d) {
        boolean flag = true;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            //pstmt
            String sql = "insert into tb_desk(num,seating) values(?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, d.getNum());
            pstmt.setInt(2, d.getSeating());
            
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
    
}
