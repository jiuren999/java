package com.tjl.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.jdbc.JDBCUtils;
import com.tjl.view.View;

public class Control {
	private static final String SQL_STU_information_SELECT = "SELECT * FROM student_information WHERE userID= ?";
	static UserDao_Imp userDao_Imp = new UserDao_Imp();
    public static void main(String[] args) {
        while (true) {
    	User user = View.indexView();
    	//UserDao_Imp userDao_Imp = new UserDao_Imp();
        //User user = null;
        //int type = -1;
        //boolean flag=true;//循环标志位

            //user = View.indexView();
            //type = userDao.login(user);
    	int type = userDao_Imp.login(user);
            switch (type) {
                case -1:
                    System.out.println("登录失败，请重新登录：");
                    break;
                case 1:
                    System.out.println("恭喜管理员登录成功！");
                    managerServer();
                    break;
                case 2:
                    System.out.println("恭喜学生登录成功！");
                    studentServer(user.getUname());
                    break;
                case 3:
                	System.out.println("恭喜老师登录成功！");
                	teacherServer(user.getUname());
                default:
                    break;
            }
        }
    }

    


     //管理员控制

    public static void managerServer(){
        boolean flag=true;//循环标志位
        //UserDao_Imp userDao_Imp = new UserDao_Imp();
        while (flag){
            int choice = View.managerMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    User newUser = View.addMenuView();
                    if (userDao_Imp.insert(newUser)){
                        System.out.println("恭喜添加成功！");
                    }else {
                        System.out.println("插入失败");
                    }
                    break;
                case 2:
                    String uname = View.deleteMenuView();
                    if (userDao_Imp.delete(uname)){
                        System.out.println("恭喜删除成功");
                    }else {
                        System.out.println("删除失败");
                    }
                    break;
                case 3:
                    User user = View.updateMenuView();
                    if (userDao_Imp.update(user)){
                        System.out.println("恭喜修改成功！");
                    }else {
                        System.out.println("修改失败");
                    }
                    break;
                case 4:
                    String uname2 = View.selectMenuView();
                    User selectUser = userDao_Imp.select(uname2);
                    if (selectUser!=null){
                        System.out.println("您查询的信息如下：");
                        //System.out.printf("姓名：%s \n密码：%s \n用户类型：%d\n",
                          //      selectUser.getUname(),selectUser.getUpass(),selectUser.getType());
                        View.printUser(selectUser);
                    }else {
                        System.out.println("查询失败，查无此人");
                    }

                    break;
                default:
                    break;
            }
        }

    }


     //学生控制
    
    public static void studentServer(String uname){
        boolean flag=true;//循环标志位
        while (flag){
            int choice = View.studentMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    String psw = View.alterPassView();
                    if (userDao_Imp.update(new User(uname,psw))){
                        System.out.println("恭喜修改密码成功！");
                    }else {
                        System.out.println("修改密码失败！");
                    }
                    break;
                case 2:
                	userDao_Imp.select_stu_information(uname);
                	break;
                case 3:
                	userDao_Imp.select_stu_sc(uname);
                	break;
                default:
                    break;
            }
        }
    }
    
    //老师控制
    
    private static void teacherServer(String uname) {
    	boolean flag=true;//循环标志位
        while (flag){
            int choice = View.teacherMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    String psw = View.alterPassView();
                    if (userDao_Imp.update(new User(uname,psw))){
                        System.out.println("恭喜修改密码成功！");
                    }else {
                        System.out.println("修改密码失败！");
                    }
                    break;
                case 2:
                	userDao_Imp.select_teacher_information(uname);
                	break;
                case 3:
                	userDao_Imp.select_teacher_sc(uname);
                	break;
                default:
                    break;
            }
        }
	}
}