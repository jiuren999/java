package com.user.dao;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Time extends Thread{
    String datestr=null;
    public void run(){
        while(true){
            Date date=new Date(MIN_PRIORITY);
            String datestr=date.toString().substring(11,19);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
