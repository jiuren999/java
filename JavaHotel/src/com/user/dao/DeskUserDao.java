/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.user.entity.DeskUse;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface DeskUserDao {
    public List<DeskUse> selectAll();
    public boolean insert(DeskUse d);
    
}
