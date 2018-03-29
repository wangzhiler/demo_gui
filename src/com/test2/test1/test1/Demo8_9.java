package com.test2.test1.test1;

import javax.swing.*;

/**
 * Created by thinkpad on 2018/1/15.
 */
public class Demo8_9 extends JFrame {

    JSplitPane jSplitPane;
    JList jList;
    JLabel jLabel1;

    public static void main(String [] args)
    {
        Demo8_9 demo8_9 = new Demo8_9();
    }

    public Demo8_9()
    {
        String [] words={"boy","girl","bird"};
        jList=new JList(words);

        jLabel1=new JLabel(new ImageIcon("images/BlueTooth.jpg"));

        //拆分窗格
        jSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jList,jLabel1);

        jSplitPane.setOneTouchExpandable(true);

        //设置布局管理器

        //添加组件
        this.add(jSplitPane);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);



    }
}
