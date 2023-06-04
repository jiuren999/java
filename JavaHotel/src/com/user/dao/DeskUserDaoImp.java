/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.db.DBCon;
import com.user.entity.DeskUse;
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
public class DeskUserDaoImp implements DeskUserDao{
    DBCon db = new DBCon();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<DeskUse> selectAll() {
        List<DeskUse> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            stmt = con.createStatement();
            String sql = "select * from tb_deskuse";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("有一行新纪录");   //uid 
                String duname=rs.getString(1);
                int duseating=rs.getInt(2);
                int duid=rs.getInt(3);
                
                DeskUse d = new DeskUse();
                d.setNum(duname);
                d.setSeating(duseating);
                d.setId(duid);

                list.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean insert(DeskUse d) {
       boolean flag = true;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            //pstmt
            String sql = "insert into tb_deskuse(num,seating) values(?,?)";
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
