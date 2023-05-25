package com.tjl.view;

import com.tjl.bean.User;

import java.util.Scanner;

public class View {
	private static Scanner input = new Scanner(System.in);
	
	static String users=null;
	// 首页界面

	public static User indexView() {
		System.out.println("***********************************");
		System.out.println("********\t教务管理系统\t*******");
		System.out.println("*********\t请根据提示操作\t*******");
		System.out.println("**********\t请输入账号：\t***********");
		String uname = input.nextLine();
		users=uname;
		System.out.println("**********\t请输入密码：\t***********");
		String upass = input.nextLine();
		System.out.println("***********************************");
		return new User(uname, upass);
	}


    //管理者菜单界面

    public static int managerMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t欢迎管理员回家\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t0.退出\t\t***********");
        System.out.println("**********\t1.添加学生信息\t***********");
        System.out.println("**********\t2.删除学生信息\t***********");
        System.out.println("**********\t3.修改学生信息\t***********");
        System.out.println("**********\t4.查询学生信息\t***********");
        String type = input.nextLine();
        int item = Integer.parseInt(type);
        if(item<0||item>4) {
            System.out.println("输入错误，请重新输入：");
            return managerMenuView();
        }
        System.out.println("***********************************");
        return item;
    }

   
    //增加用户界面

    public static User addMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t添加用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }


    //删除用户界面
    
    public static String deleteMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t删除用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }


    //更新修改用户界面
    
    public static User updateMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t修改用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入新密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

 
    //查询用户界面
   
    public static String selectMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t查询用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入查询账号：\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }
    public static void printUser(User user) {
    	System.out.println("用户ID："+user.getId());
    	System.out.println("用户名："+user.getUname());
    	System.out.println("密码："+user.getUpass());
    	if(user.getType()==1) {
    		System.out.println("用户权限：管理员");
    	}else if(user.getType()==2){
    		System.out.println("用户权限：学生");
    	}else {
    		System.out.println("用户权限：老师");
    	}
    }

    //学生界面
    public static int studentMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t欢迎学生回家\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t0.退出\t\t***********");
        System.out.println("**********\t1.修改密码\t***********");
        System.out.println("**********\t2.查询个人信息\t***********");
        System.out.println("**********\t3.查询选课信息\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 3) {
                flag = false;//退出循环
                break;
            }
            System.out.println("输入错误，请重新输入：");
        }
        System.out.println("***********************************");
        return num;
    }
    
     //修改密码界面
        
    public static String alterPassView(){
        System.out.println("***********************************");
        System.out.println("********\t修改密码界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入新密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return upass;
    }
    
  //学生界面
    public static int teacherMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t欢迎老师回家\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t0.退出\t\t***********");
        System.out.println("**********\t1.修改密码\t***********");
        System.out.println("**********\t2.查询个人信息\t***********");
        System.out.println("**********\t3.查询课表信息\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 3) {
                flag = false;//退出循环
                break;
            }
            System.out.println("输入错误，请重新输入：");
        }
        System.out.println("***********************************");
        return num;
    }
    
    
    
}
