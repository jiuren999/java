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
public class Buy implements Serializable {

    private String num;
    private String name;
    private String code;
    private String unit;
    private int unit_price;
    private int count;
    private int total;
    private int id;
    private String bstate;

    public Buy() {
        super();
    }

    public Buy(String num, String name, String code, String unit,
            int unit_price, int count, int total,int id,String bstate) {
        super();
        this.num = num;
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.unit_price = unit_price;
        this.count = count;
        this.total = total;
        this.id = id;
        this.bstate=bstate;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
