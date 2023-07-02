package com.user.dao;

import com.user.entity.User;
import java.util.List;

public interface UserDao {
	public boolean isExist(String name,String password);
	public boolean insert(User u);
        public List<User> selectAll();
	public boolean delect(int id);
	public User selectById(int id);
	public boolean update(User user, int id);
        public List<User> selectByMoHu(String name);
        public List<User> selectZuHeB(String name,int age1,int age2);
        public boolean updatePass(String name,String oldpassword,String newpassword);

}
