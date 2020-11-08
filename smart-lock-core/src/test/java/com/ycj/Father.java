package com.ycj;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/11/8 下午8:08
 */
public class Father {


    public void getName(){
        System.out.println("father name");
    }


    public void getFamily(){

        System.out.println("family name");

        getName();
    }
}
