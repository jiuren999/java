/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.entity;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Goods implements Serializable {

    private String num;
    private String name;
    private int gnum;
    private int gumoney;
    private int gtotal;

    public Goods() {
        super();
    }

    public Goods(String num, String name, int gnum, int gumoney, int gtotal) {
        super();
        this.num = num;
        this.name = name;
        this.gnum = gnum;
        this.gumoney = gumoney;
        this.gtotal = gtotal;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public int getGumoney() {
        return gumoney;
    }

    public void setGumoney(int gumoney) {
        this.gumoney = gumoney;
    }

    public int getGtotal() {
        return gtotal;
    }

    public void setGtotal(int gtotal) {
        this.gtotal = gtotal;
    }

}
