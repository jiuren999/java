package com.user.dao;

import com.user.entity.Desk;
import java.util.List;

public interface DeskDao {
    public List<Desk> selectAll();
    public boolean delect(String num);
    public boolean insert(Desk d);
    
}
