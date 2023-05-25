package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao {

	/**
     * ��¼�ķ���
     * @param user ������¼���û� �����û�������
     * @return -1��ʾ��¼ʧ�� 1��ʾ����Ա��¼�ɹ� 2��ʾѧ����½�ɹ�
     */
    int login(User user);

    /**
     * �������ѧ���ķ���
     * @param user Ҫ��ӵ�ѧ������ �����û�������
     * @return true��ʾ��ӳɹ���false��ʾ���ʧ��
     */
    boolean insert(User user);

    /**
     *ɾ��ѧ���˻��ķ���
     * @param uname Ҫɾ�����û���
     * @return true��ʾɾ���ɹ���false��ʾɾ��ʧ��
     */
    boolean delete(String uname);

    /**
     * �޸�ѧ����Ϣ�ķ���
     * @param user �޸ĵ�ѧ����Ϣ
     * @return true��ʾ�޸ĳɹ���false��ʾ�޸�ʧ��
     */
    boolean update(User user);

    /**
     * ��ѯѧ����Ϣ�ķ���
     * @param uname Ҫ�޸ĵ�ѧ���û���
     * @return ��ѯ�ɹ�����User����ѯʧ�ܷ���null
     */
    User select(String uname);
    User select_stu_information(String uname);
    User select_stu_sc(String uname);
    User select_teacher_information(String uname);
    User select_teacher_sc(String uname);
    
	
}
