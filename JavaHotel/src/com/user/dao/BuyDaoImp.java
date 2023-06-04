/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.db.DBCon;
import com.user.entity.Buy;
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
public class BuyDaoImp implements BuyDao {

    DBCon db = new DBCon();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<Buy> selectAll() {
        List<Buy> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            stmt = con.createStatement();
            String sql = "select * from tb_buy";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("有一行新纪录");   //uid 
                int uid = rs.getInt(1);
                String bnum = rs.getString(2);
                String bname = rs.getString(3);
                String bcode = rs.getString(4);
                String bunit = rs.getString(5);
                int bunit_price = rs.getInt(6);
                int bnumber = rs.getInt(7);
                int btotal = rs.getInt(8);
                String bstate = rs.getString(9);

                Buy b = new Buy();
                b.setId(uid);
                b.setNum(bnum);
                b.setName(bname);
                b.setCode(bcode);
                b.setUnit(bunit);
                b.setUnit_price(bunit_price);
                b.setCount(bnumber);
                b.setTotal(btotal);
                b.setBstate(bstate);

                list.add(b);

            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean insert(Buy b) {
        boolean flag = true;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            //pstmt
            String sql = "insert into tb_buy(num,name,code,unit,unit_price,count,total,bstate) values(?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, b.getNum());
            pstmt.setString(2, b.getName());
            pstmt.setString(3, b.getCode());
            pstmt.setString(4, b.getUnit());
            pstmt.setInt(5, b.getUnit_price());
            pstmt.setInt(6, b.getCount());
            pstmt.setInt(7, b.getTotal());
            pstmt.setString(8, b.getBstate());

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

    public Buy selectById(int id) {
        Buy b = null;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "select * from tb_buy where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();// 执行sql语句

            while (rs.next()) {
                System.out.println("有一行新纪录");
                int bid = rs.getInt(1);
                String bnum = rs.getString(2);
                String bname = rs.getString(3);
                String bcode = rs.getString(4);
                String bunit = rs.getString(5);
                int bunit_price = rs.getInt(6);
                int bnumber = rs.getInt(7);
                int btotal = rs.getInt(8);
                String bstate = rs.getString(9);

                b = new Buy();
                b.setId(bid);
                b.setNum(bnum);
                b.setName(bname);
                b.setCode(bcode);
                b.setUnit(bunit);
                b.setUnit_price(bunit_price);
                b.setCount(bnumber);
                b.setTotal(btotal);
                b.setBstate(bstate);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    public boolean update(Buy buy, int id) {
        boolean flag = false;
        try {
            if (this.selectById(id) != null) {
                System.out.println("数据库中存在此数据，可查询");
                con = db.getCon();
                if (con == null) {
                    System.out.println("UserDaoImp中数据库连接失败");
                }
                String sql = "update tb_buy set num=?,name=?,code=?,unit=?,unit_price=?,count=?,total=?,bstate=? where id=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, buy.getNum());
                pstmt.setString(2, buy.getName());
                pstmt.setString(3, buy.getCode());
                pstmt.setString(4, buy.getUnit());
                pstmt.setInt(5, buy.getUnit_price());
                pstmt.setInt(6, buy.getCount());
                pstmt.setInt(7, buy.getTotal());
                pstmt.setString(8, buy.getBstate());
                pstmt.setInt(9, id);
                int count = pstmt.executeUpdate();
                if (count > 0) {
                    flag = true;
                    System.out.println("成功修改" + count + "条数据！");
                }
            } else {
                System.out.println("数据库中不存在该数据，无法查询");
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
