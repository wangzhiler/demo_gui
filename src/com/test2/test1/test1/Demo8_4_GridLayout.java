package com.test2.test1.test1;

import java.awt.*;
import javax.swing.*;
/**
 * Created by thinkpad on 2018/1/14.
 */
public class Demo8_4_GridLayout extends JFrame{

    int size=9;
    JButton jbs[]=new JButton[size];
    public static void main(String [] args){
        Demo8_4_GridLayout demo8_4_gridLayout=new Demo8_4_GridLayout();
    }

    public Demo8_4_GridLayout()
    {
        //创建组件
        for(int i=0; i<size; i++){
            jbs[i]=new JButton(String.valueOf(i));
        }

        //设置网格布局
        this.setLayout(new GridLayout(3,3,10,10));

        //添加组件
        for(int i=0; i<size;i++){
            this.add(jbs[i]);
        }

        //设置窗体属性
        this.setTitle("网格布局");
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);

        //显示
        this.setVisible(true);


    }
}
