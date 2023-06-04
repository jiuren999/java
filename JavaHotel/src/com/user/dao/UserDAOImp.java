package com.user.dao;

import com.db.DBCon;
import com.user.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDao {

    //一个类四个接口对象
    DBCon db = new DBCon();
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public boolean isExist(String name, String password) {
        boolean flag = false;
        //模拟  连接  stmt pstmt  sql
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            String sql = "select * from tb_user where name=? and password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("用户名和密码一致");
                flag = true;
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insert(User u) {
        boolean flag = true;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            //pstmt
            String sql = "insert into tb_user(name,sex,age,id_card,password,freeze) values(?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSex());
            pstmt.setInt(3, u.getAge());
            pstmt.setString(4, u.getId_card());
            pstmt.setString(5, u.getPassword());
            pstmt.setString(6, u.getFreeze());

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
    public List<User> selectAll() {
        List<User> list = new ArrayList();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.print("数据库连接失败");
            }
            stmt = con.createStatement();
            String sql = "select * from tb_user";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("有一行新纪录");   //uid 
                int uid = rs.getInt(1);
                String uname = rs.getString(2);
                String sex = rs.getString(3);
                int age = rs.getInt(4);
                String id_card = rs.getString(5);
                String password = rs.getString(6);
                String freeze = rs.getString(7);
               
                User u = new User();
                u.setId(uid);
                u.setName(uname);
                u.setSex(sex);
                u.setAge(age);
                u.setId_card(id_card);
                u.setPassword(password);
                u.setFreeze(freeze);
               
                list.add(u);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean delect(int id) {
        boolean flag = false;
        try {// 1、连接
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "delete from tb_user where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
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
    public User selectById(int id) {
        User u = null;
        try {
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "select * from tb_user where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();// 执行sql语句
            System.out.println("id\t用户名\t性别\t年龄\tId卡\t密码\t冻结");
            while (rs.next()) {
                System.out.println("有一行新纪录");
                int uid = rs.getInt(1);
                String uname = rs.getString(2);
                String sex = rs.getString(3);
                int age = rs.getInt(4);
                String id_card = rs.getString(5);
                String password = rs.getString(6);
                String freeze = rs.getString(7);
               
                System.out.println(uid + "\t" + uname + "\t"  + sex + "\t" 
                        + age+ "\t"+id_card+ "\t"+ password + "\t" + freeze);
               
                u = new User();
                u.setId(uid);
                u.setName(uname);
                u.setSex(sex);
                u.setAge(age);
                u.setId_card(id_card);
                u.setPassword(password);
                u.setFreeze(freeze);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean update(User user, int id) {
        boolean flag = false;
        try {
            if (this.selectById(id) != null) {
                System.out.println("数据库中存在此数据，可查询");
                con = db.getCon();
                if (con == null) {
                    System.out.println("UserDaoImp中数据库连接失败");
                }
                String sql = "update tb_user set name=?,sex=?,age=?,id_card=?,password=?,freeze=? where id=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getSex());
                pstmt.setInt(3, user.getAge());
                pstmt.setString(4, user.getId_card());
                pstmt.setString(5, user.getPassword());
                pstmt.setString(6, user.getFreeze());
                pstmt.setInt(7, id);
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

    @Override
    public List<User> selectByMoHu(String name) {
        List<User> list = new ArrayList<User>();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "select * from tb_user where name like ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();// 执行sql语句
            System.out.println("id\t用户名\t性别\t年龄\tId卡\t密码\t冻结");
            while (rs.next()) {
                int uid = rs.getInt(1);
                String uname = rs.getString(2);
                String sex = rs.getString(3);
                int age = rs.getInt(4);
                String id_card = rs.getString(5);
                String password = rs.getString(6);
                String freeze = rs.getString(7);
               
                System.out.println(uid + "\t" + uname + "\t"  + sex + "\t" 
                        + age+ "\t"+id_card+ "\t"+ password + "\t" + freeze);
               
                User u = new User();
                u.setId(uid);
                u.setName(uname);
                u.setSex(sex);
                u.setAge(age);
                u.setId_card(id_card);
                u.setPassword(password);
                u.setFreeze(freeze);
                
                list.add(u);
            }
            rs.close();
            // stmt.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<User> selectZuHeB(String name, int age1, int age2) {
        List<User> list = new ArrayList<User>();
        try {
            con = db.getCon();
            if (con == null) {
                System.out.println("UserDaoImp中数据库连接失败");
            }
            String sql = "select * from tb_user where name like ? and age between ? and ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            pstmt.setInt(2, age1);
            pstmt.setInt(3, age2);
            rs = pstmt.executeQuery();// 执行sql语句
            System.out.println("id\t用户名\t性别\t年龄\tId卡\t密码\t冻结");
            while (rs.next()) {
             int uid = rs.getInt(1);
                String uname = rs.getString(2);
                String sex = rs.getString(3);
                int age = rs.getInt(4);
                String id_card = rs.getString(5);
                String password = rs.getString(6);
                String freeze = rs.getString(7);
               
                System.out.println(uid + "\t" + uname + "\t"  + sex + "\t" 
                        + age+ "\t"+id_card+ "\t"+ password + "\t" + freeze);
               
                User u = new User();
                u.setId(uid);
                u.setName(uname);
                u.setSex(sex);
                u.setAge(age);
                u.setId_card(id_card);
                u.setPassword(password);
                u.setFreeze(freeze);
                
                list.add(u);
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
    public boolean updatePass(String name,String oldpassword,String newpassword) {
     boolean flag = false;
        try {
                con = db.getCon();
                if (con == null) {
                    System.out.println("UserDaoImp中数据库连接失败");
                }
                String sql = "update tb_user set password=? where name = ? and password = ?";
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1, newpassword);
                pstmt.setString(2, name);
                pstmt.setString(3, oldpassword);
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
