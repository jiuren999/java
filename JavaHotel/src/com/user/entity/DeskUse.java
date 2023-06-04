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
public class DeskUse implements Serializable {

    private String num;
    private int seating;
    private int id;

    public DeskUse() {
        super();
    }

    public DeskUse(String num, int seating,int id) {
        super();
        this.num = num;
        this.seating = seating;
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
