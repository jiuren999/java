/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.user.entity.Buy;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface BuyDao {
    public List<Buy> selectAll();
    public boolean insert(Buy b);
    public Buy selectById(int id);
    public boolean update(Buy buy, int id);
    
}
