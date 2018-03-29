package com.NetWork.qq1.qqClient.view;

import javax.swing.*;

//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

/**
 * Created by thinkpad on 2018/3/29.
 */
public class qqChat extends JFrame {

    JTextArea jta;
    JTextField jtf;
    JButton jb;
    JPanel jp;

    public static void main(String[] args) {
        qqChat qqChat = new qqChat("2");
    }

    public qqChat(String friendNo) {
        jta = new JTextArea();
        jtf = new JTextField(15);
        jb = new JButton("发送");
        jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);

        this.add(jta, "Center");
        this.add(jp, "South");

        this.setTitle("你正在和"+friendNo+"聊天");

        this.setIconImage((new ImageIcon("images/qq/qq.gif").getImage()));
        this.setSize(300, 200);
        this.setVisible(true);
    }
}














