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
        //boolean flag=true;//ѭ����־λ

            //user = View.indexView();
            //type = userDao.login(user);
    	int type = userDao_Imp.login(user);
            switch (type) {
                case -1:
                    System.out.println("��¼ʧ�ܣ������µ�¼��");
                    break;
                case 1:
                    System.out.println("��ϲ����Ա��¼�ɹ���");
                    managerServer();
                    break;
                case 2:
                    System.out.println("��ϲѧ����¼�ɹ���");
                    studentServer(user.getUname());
                    break;
                case 3:
                	System.out.println("��ϲ��ʦ��¼�ɹ���");
                	teacherServer(user.getUname());
                default:
                    break;
            }
        }
    }

    


     //����Ա����

    public static void managerServer(){
        boolean flag=true;//ѭ����־λ
        //UserDao_Imp userDao_Imp = new UserDao_Imp();
        while (flag){
            int choice = View.managerMenuView();//ѡ�����
            switch (choice){
                case 0:
                    System.out.println("�˳�ϵͳ���ټ���");
                    flag=false;
                    break;
                case 1:
                    User newUser = View.addMenuView();
                    if (userDao_Imp.insert(newUser)){
                        System.out.println("��ϲ��ӳɹ���");
                    }else {
                        System.out.println("����ʧ��");
                    }
                    break;
                case 2:
                    String uname = View.deleteMenuView();
                    if (userDao_Imp.delete(uname)){
                        System.out.println("��ϲɾ���ɹ�");
                    }else {
                        System.out.println("ɾ��ʧ��");
                    }
                    break;
                case 3:
                    User user = View.updateMenuView();
                    if (userDao_Imp.update(user)){
                        System.out.println("��ϲ�޸ĳɹ���");
                    }else {
                        System.out.println("�޸�ʧ��");
                    }
                    break;
                case 4:
                    String uname2 = View.selectMenuView();
                    User selectUser = userDao_Imp.select(uname2);
                    if (selectUser!=null){
                        System.out.println("����ѯ����Ϣ���£�");
                        //System.out.printf("������%s \n���룺%s \n�û����ͣ�%d\n",
                          //      selectUser.getUname(),selectUser.getUpass(),selectUser.getType());
                        View.printUser(selectUser);
                    }else {
                        System.out.println("��ѯʧ�ܣ����޴���");
                    }

                    break;
                default:
                    break;
            }
        }

    }


     //ѧ������
    
    public static void studentServer(String uname){
        boolean flag=true;//ѭ����־λ
        while (flag){
            int choice = View.studentMenuView();//ѡ�����
            switch (choice){
                case 0:
                    System.out.println("�˳�ϵͳ���ټ���");
                    flag=false;
                    break;
                case 1:
                    String psw = View.alterPassView();
                    if (userDao_Imp.update(new User(uname,psw))){
                        System.out.println("��ϲ�޸�����ɹ���");
                    }else {
                        System.out.println("�޸�����ʧ�ܣ�");
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
    
    //��ʦ����
    
    private static void teacherServer(String uname) {
    	boolean flag=true;//ѭ����־λ
        while (flag){
            int choice = View.teacherMenuView();//ѡ�����
            switch (choice){
                case 0:
                    System.out.println("�˳�ϵͳ���ټ���");
                    flag=false;
                    break;
                case 1:
                    String psw = View.alterPassView();
                    if (userDao_Imp.update(new User(uname,psw))){
                        System.out.println("��ϲ�޸�����ɹ���");
                    }else {
                        System.out.println("�޸�����ʧ�ܣ�");
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