package com.test2.test1.test1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by thinkpad on 2018/1/15.
 */
public class Demo8_8 extends JFrame {

    JPanel jPanel1,jPanel2;
    JLabel jLabel1,jLabel2;
    JComboBox jComboBox1;
    JList jList;
    JScrollPane jScrollPane;

    public static void main(String [] args)
    {
        Demo8_8 demo8_8 = new Demo8_8();
    }

    public Demo8_8()
    {
        jPanel1=new JPanel();
        jPanel2=new JPanel();

        jLabel1=new JLabel("你的籍贯");
        jLabel2=new JLabel("旅游地点");

        String []jq={"北京","上海","天津","火星"};
        jComboBox1 = new JComboBox(jq);

        String []dd={"九寨沟","故宫","长城","天安门"};
        jList=new JList(dd);

        //scroll
        jList.setVisibleRowCount(2);
        jScrollPane=new JScrollPane(jList);

        jPanel1.add(jLabel1);
        jPanel1.add(jScrollPane);

        jPanel2.add(jLabel2);
        jPanel2.add(jComboBox1);

        this.add(jPanel1);
        this.add(jPanel2);

        this.setLayout(new GridLayout(3,1));
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
