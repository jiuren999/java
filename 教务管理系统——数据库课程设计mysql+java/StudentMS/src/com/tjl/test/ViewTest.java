package com.tjl.test;

//import static org.junit.Assert.*;
//import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {
	//@Test
    public void indexViewTest() throws Exception{
        User user1 = View.indexView();
        System.out.println(user1);
    }

	
	//@Test
	public void managerMenuViewTest() throws Exception{
		int item = View.managerMenuView();
		System.out.println(item); 
	
	}
	
	//@Test
	public void addMenuViewTest() throws Exception{
		User user = View.addMenuView();
		System.out.println(user);
	}
	
	/*
	 * @Test public void main(String[] args) throws Exception{
	 * //indexViewTest();//首页测试 managerMenuViewTest();//管理界面测试
	 * 
	 * }
	 */
	 
}
