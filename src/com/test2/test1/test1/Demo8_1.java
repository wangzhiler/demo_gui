package com.test2.test1.test1;

import javax.swing.*;

/**
 * Created by thinkpad on 2018/1/14.
 */
public class Demo8_1  extends JFrame{

    JButton jb1=null;

    public static void main(String [] args){

        Demo8_1 demo8_1=new Demo8_1();

    }

    public Demo8_1(){
//        //Jrame是一个顶层容器（可以添加其他swing组件的类）
//        JFrame jf=new JFrame();

        //创建一个button按钮
        jb1=new JButton("我是按钮");

        //给窗口设置标题
        this.setTitle("hello,world");

        //设置大小，按像素[1像素=?cm]
        this.setSize(200, 200);

        //添加jbutton组件
        this.add(jb1);

        //设置初始位置
        this.setLocation(100,200);

        //设置当关闭窗口时，保证jvm也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示
        this.setVisible(true);
    }


}
