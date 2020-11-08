package com.ycj;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/11/8 下午8:16
 */
public class Sun extends Father {


    public void getName(){

        System.out.println("sun name");
    }


    public static void main(String[] args) {

        new Sun().getFamily();

    }
}
