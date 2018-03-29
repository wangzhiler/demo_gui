package com.test2.test1.test1;

import javax.swing.*;
import java.awt.*;

/**
 * 1. 继承JFrame
 * 2. 定义你需要的组件
 * 3. 创建组件（构造函数）
 * 4. 添加组件
 * 5. 对窗体设置
 * 6. 显示窗体
 */
public class Demo8_3_FlowLayout extends JFrame{
    //定义组件
    JButton jb1,jb2,jb3,jb4,jb5;

    public static void main(String [] args){

        Demo8_3_FlowLayout demo8_3_flowLayout=new Demo8_3_FlowLayout();
    }

    public Demo8_3_FlowLayout()
    {
        //创建组件
        jb1=new JButton("a");
        jb2=new JButton("b");
        jb3=new JButton("c");
        jb4=new JButton("d");
        jb5=new JButton("e");

        //添加各个组件
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);

        //设置布局管理器
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        //设置窗体属性
        this.setTitle("流式局案例");
        this.setSize(300,200);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示窗体
        this.setVisible(true);

    }
}
