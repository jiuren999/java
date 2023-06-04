package com.user.dao;

import com.user.entity.Sort;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public interface SortDao {
    public List<Sort> selectAll();
    public boolean delect(int id);
    public boolean insert(Sort s);
}
