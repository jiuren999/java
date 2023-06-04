package com.user.dao;

import com.user.entity.Menu;
import java.util.List;


public interface MenuDao {
    public List<Menu> selectAll();
    public boolean delect(String num);
    public boolean insert(Menu m);
    public Menu selectByNum(String num);
}
