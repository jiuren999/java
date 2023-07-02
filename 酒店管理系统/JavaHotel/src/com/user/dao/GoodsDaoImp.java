/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.db.DBCon;
import com.user.entity.Goods;
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
public class GoodsDaoImp implements GoodsDao{
    DBCon db = new DBCon();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<Goods> selectAll() {
        List<Goods> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            stmt = con.createStatement();
            String sql = "select * from tb_goods";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("有一行新纪录");   //uid 
                String gnum=rs.getString(1);
                String gname=rs.getString(2);
                int ggnum=rs.getInt(3);
                int gmoney=rs.getInt(4);
                int gtotal=rs.getInt(5);
                
                Goods g = new Goods();
                g.setNum(gnum);
                g.setName(gname);
                g.setGnum(ggnum);
                g.setGumoney(gmoney);
                g.setGtotal(gtotal);
               
                list.add(g);

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
            String sql = "delete from tb_goods where num=?";
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
    public boolean insert(Goods g) {
        boolean flag = true;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            //pstmt
            String sql = "insert into tb_goods(num,name,gnum,gumoney,gtotal) values(?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, g.getNum());
            pstmt.setString(2, g.getName());
            pstmt.setInt(3, g.getGnum());
            pstmt.setInt(4, g.getGumoney());
            pstmt.setInt(5, g.getGtotal());
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
    public List<Goods> selectByNum(String num) {
       List<Goods> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "select * from tb_goods where num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();// 执行sql语句
            while (rs.next()) {
                System.out.println("有一行新纪录");
                String gnum=rs.getString(1);
                String gname=rs.getString(2);
                int ggnum=rs.getInt(3);
                int gmoney=rs.getInt(4);
                int gtotal=rs.getInt(5);
                
                Goods g = new Goods();
                g.setNum(gnum);
                g.setName(gname);
                g.setGnum(ggnum);
                g.setGumoney(gmoney);
                g.setGtotal(gtotal);
                list.add(g);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(Goods goods, String num) {
        boolean flag = false;
        try {
                con = db.getCon();
                if (con == null) {
                    System.out.println("UserDaoImp中数据库连接失败");
                }
                String sql = "update tb_goods set num=?,name=?,gnum=?,gumoney=?,gtotal=? where num=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, goods.getNum());
                pstmt.setString(2, goods.getName());
                pstmt.setInt(3, goods.getGnum());
                pstmt.setInt(4, goods.getGumoney());
                pstmt.setInt(5, goods.getGtotal());
                pstmt.setString(6, num);
                
                int count = pstmt.executeUpdate();
                if (count > 0) {
                    flag = true;
                    System.out.println("成功修改" + count + "条数据！");
                }
                
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
    
}
