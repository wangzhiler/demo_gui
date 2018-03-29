package com.test2.test1.test1;

import java.awt.*;
import javax.swing.*;

/**
 * 多种布局管理器的使用
 * Created by thinkpad on 2018/1/15.
 */
public class Demo8_5_jpanel extends JFrame{

    //定义组件
    JPanel jp1,jp2;
    JButton jb1,jb2,jb3,jb4,jb5,jb6;

    public static void main(String [] args){
        Demo8_5_jpanel demo8_5_jpanel=new Demo8_5_jpanel();
    }

    public Demo8_5_jpanel()
    {
        //创建组件
        //JPanel布局默认是FlowLayout
        jp1=new JPanel();
        jp2=new JPanel();

        jb1=new JButton("西瓜");
        jb2=new JButton("苹果");
        jb3=new JButton("荔枝");
        jb4=new JButton("葡萄");
        jb5=new JButton("桔子");
        jb6=new JButton("香蕉");

        //设置布局

        //添加JPanel
        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

        //把Panel加入JFrame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jb6, BorderLayout.CENTER);
        this.add(jp2, BorderLayout.SOUTH);

        this.setSize(300,150);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
