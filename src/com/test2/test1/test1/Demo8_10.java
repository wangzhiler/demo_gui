package com.test2.test1.test1;

import javax.swing.*;
import java.awt.*;

/**
 * qq聊天
*/
public class Demo8_10 extends JFrame {

    JTextArea jTextArea=null;
    JPanel jPanel=null;
    JComboBox jComboBox = null;
    JTextField jTextField = null;
    JButton jButton = null;

    JScrollPane jScrollPane=null;

    public static void main(String [] args)
    {
        Demo8_10 demo8_10 = new Demo8_10();
    }

    public Demo8_10()
    {
        jTextArea = new JTextArea();
        jScrollPane=new JScrollPane(jTextArea);
        jPanel = new JPanel();
        String []chatter={"布什","拉登"};
        jComboBox = new JComboBox(chatter);
        jTextField = new JTextField(10);
        jButton=new JButton("发送");

        jPanel.add(jComboBox);
        jPanel.add(jTextField);
        jPanel.add(jButton);

        this.add(jScrollPane);
        this.add(jPanel, BorderLayout.SOUTH);

        this.setSize(300,200);
        this.setTitle("腾讯qq");
        this.setIconImage(new ImageIcon("images\\qq.JPG").getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
