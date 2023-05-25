package com.tjl.view;

import com.tjl.bean.User;

import java.util.Scanner;

public class View {
	private static Scanner input = new Scanner(System.in);
	
	static String users=null;
	// ��ҳ����

	public static User indexView() {
		System.out.println("***********************************");
		System.out.println("********\t�������ϵͳ\t*******");
		System.out.println("*********\t�������ʾ����\t*******");
		System.out.println("**********\t�������˺ţ�\t***********");
		String uname = input.nextLine();
		users=uname;
		System.out.println("**********\t���������룺\t***********");
		String upass = input.nextLine();
		System.out.println("***********************************");
		return new User(uname, upass);
	}


    //�����߲˵�����

    public static int managerMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ӭ����Ա�ؼ�\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t0.�˳�\t\t***********");
        System.out.println("**********\t1.���ѧ����Ϣ\t***********");
        System.out.println("**********\t2.ɾ��ѧ����Ϣ\t***********");
        System.out.println("**********\t3.�޸�ѧ����Ϣ\t***********");
        System.out.println("**********\t4.��ѯѧ����Ϣ\t***********");
        String type = input.nextLine();
        int item = Integer.parseInt(type);
        if(item<0||item>4) {
            System.out.println("����������������룺");
            return managerMenuView();
        }
        System.out.println("***********************************");
        return item;
    }

   
    //�����û�����

    public static User addMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t����û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t���������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }


    //ɾ���û�����
    
    public static String deleteMenuView(){
        System.out.println("***********************************");
        System.out.println("********\tɾ���û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }


    //�����޸��û�����
    
    public static User updateMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t�޸��û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t�����������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

 
    //��ѯ�û�����
   
    public static String selectMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ѯ�û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������ѯ�˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }
    public static void printUser(User user) {
    	System.out.println("�û�ID��"+user.getId());
    	System.out.println("�û�����"+user.getUname());
    	System.out.println("���룺"+user.getUpass());
    	if(user.getType()==1) {
    		System.out.println("�û�Ȩ�ޣ�����Ա");
    	}else if(user.getType()==2){
    		System.out.println("�û�Ȩ�ޣ�ѧ��");
    	}else {
    		System.out.println("�û�Ȩ�ޣ���ʦ");
    	}
    }

    //ѧ������
    public static int studentMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ӭѧ���ؼ�\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t0.�˳�\t\t***********");
        System.out.println("**********\t1.�޸�����\t***********");
        System.out.println("**********\t2.��ѯ������Ϣ\t***********");
        System.out.println("**********\t3.��ѯѡ����Ϣ\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 3) {
                flag = false;//�˳�ѭ��
                break;
            }
            System.out.println("����������������룺");
        }
        System.out.println("***********************************");
        return num;
    }
    
     //�޸��������
        
    public static String alterPassView(){
        System.out.println("***********************************");
        System.out.println("********\t�޸��������\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�����������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return upass;
    }
    
  //ѧ������
    public static int teacherMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ӭ��ʦ�ؼ�\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t0.�˳�\t\t***********");
        System.out.println("**********\t1.�޸�����\t***********");
        System.out.println("**********\t2.��ѯ������Ϣ\t***********");
        System.out.println("**********\t3.��ѯ�α���Ϣ\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 3) {
                flag = false;//�˳�ѭ��
                break;
            }
            System.out.println("����������������룺");
        }
        System.out.println("***********************************");
        return num;
    }
    
    
    
}
