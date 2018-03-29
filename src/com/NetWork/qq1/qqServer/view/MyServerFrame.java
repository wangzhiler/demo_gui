package com.NetWork.qq1.qqServer.view;

import javax.swing.*;

/**
 * Created by thinkpad on 2018/3/29.
 * <p>
 * 服务器端的控制界面，可以完成启动服务器，关闭服务器
 * 可以管理和监控用户
 */
public class MyServerFrame extends JFrame{

    JPanel jp1;
    JButton jb1,jb2;

    public static void main(String[] args) {
        MyServerFrame myServerFrame = new MyServerFrame();
    }

    public MyServerFrame() {
        jp1 = new JPanel();
        jb1 = new JButton("启动服务器");
        jb2 = new JButton("关闭服务器");
        jp1.add(jb1);
        jp1.add(jb2);

        this.add(jp1);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
