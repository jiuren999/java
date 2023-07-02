/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.dao;

import com.user.entity.Goods;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface GoodsDao {
    public List<Goods> selectAll();
    public boolean delect(String num);
    public boolean insert(Goods g);
    public List<Goods> selectByNum(String num);
    public boolean update(Goods goods, String num);
}
