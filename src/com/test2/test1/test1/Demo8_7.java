package com.test2.test1.test1;


import javax.swing.*;
import java.awt.*;

/**
 * Created by thinkpad on 2018/1/15.
 */
public class Demo8_7 extends JFrame{

    JPanel jPanel1,jPanel2,jPanel3;
    JLabel jLabel1,jLabel2;
    JButton jButton1,jButton2;
    JCheckBox jCheckBox1,jCheckBox2,jCheckBox3;
    JRadioButton jRadioButton1,jRadioButton2;
    ButtonGroup buttonGroup;

    public static void main(String [] args)
    {
        Demo8_7 demo8_7=new Demo8_7();
    }

    public Demo8_7()
    {
        jPanel1=new JPanel();
        jPanel2=new JPanel();
        jPanel3=new JPanel();
        jLabel1=new JLabel("你喜欢的运动");
        jLabel2=new JLabel("你的性别");
        jButton1=new JButton("注册用户");
        jButton2=new JButton("取消注册");

        jCheckBox1=new JCheckBox("足球");
        jCheckBox2=new JCheckBox("网球");
        jCheckBox3=new JCheckBox("乒乓球");

        jRadioButton1=new JRadioButton("男");
        jRadioButton2=new JRadioButton("女");
        buttonGroup=new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

        //设置布局管理
        this.setLayout(new GridLayout(3,1));

        //添加组件
        jPanel1.add(jLabel1);
        jPanel1.add(jCheckBox1);
        jPanel1.add(jCheckBox2);
        jPanel1.add(jCheckBox3);


        jPanel2.add(jLabel2);
        jPanel2.add(jRadioButton1);
        jPanel2.add(jRadioButton2);

        jPanel3.add(jButton1);
        jPanel3.add(jButton2);


        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);

        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
