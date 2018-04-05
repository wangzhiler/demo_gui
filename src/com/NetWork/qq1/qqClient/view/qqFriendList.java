package com.NetWork.qq1.qqClient.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by thinkpad on 2018/3/26.
 */
public class qqFriendList extends JFrame implements ActionListener, MouseListener{


    //处理第一张卡片
    JPanel jphy1,jphy2,jphy3;
    JButton jphy_jb1,jphy_jb2,jphy_jb3;
    JScrollPane jsp1;

    //处理第二张卡片(陌生人)
    JPanel jpmsr1,jpmsr2,jpmsr3;
    JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
    JScrollPane jsp2;
    String owner;

    //把整个JFrame设置成CardLayout
    CardLayout cl;

    public static void main(String[] args) {
//        qqFriendList qqFriendList = new qqFriendList();
    }

    public qqFriendList(String ownerId) {
        this.owner=ownerId;

        //处理第一张卡片
        CardFriend();

        //处理第二张卡片
        CardStranger();


        cl = new CardLayout();
        this.setLayout(cl);
        this.add(jphy1, "1");
        this.add(jpmsr1, "2");
        //在窗口显示自己的编号
        this.setTitle(ownerId);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 500);
        this.setVisible(true);

    }

    private void CardStranger() {
        //处理第二张卡片
        jpmsr_jb1 = new JButton("我的好友");
        jpmsr_jb1.addActionListener(this);
        jpmsr_jb2 = new JButton("陌生人");
        jpmsr_jb3 = new JButton("黑名单");

        jpmsr1 = new JPanel(new BorderLayout());
        //假定有50个好友  4 4为行间距、列间距
        jpmsr2 = new JPanel(new GridLayout(20, 1, 4, 4));
        //给jphy2,初始化50个好友
        JLabel[] jlb2 = new JLabel[20];

        for (int i = 0; i < jlb2.length; i++) {
            jlb2[i] = new JLabel(i + 1 + "", new ImageIcon("images/qq/mm.jpg"), JLabel.LEFT);
            jpmsr2.add(jlb2[i]);
        }

        jpmsr3 = new JPanel(new GridLayout(2, 1));
        //把两个按钮加入到jphy3
        jpmsr3.add(jpmsr_jb1);
        jpmsr3.add(jpmsr_jb2);


        jsp2 = new JScrollPane(jpmsr2);

        jpmsr1.add(jpmsr3, "North");
        jpmsr1.add(jsp2, "Center");
        jpmsr1.add(jpmsr_jb3, "South");
    }

    private void CardFriend() {
        //处理第一张卡片
        jphy_jb1 = new JButton("我的好友");
        jphy_jb2 = new JButton("陌生人");
        jphy_jb2.addActionListener(this);
        jphy_jb3 = new JButton("黑名单");

        jphy1 = new JPanel(new BorderLayout());
        //假定有50个好友  4 4为行间距、列间距
        jphy2 = new JPanel(new GridLayout(50, 1, 4, 4));
        //给jphy2,初始化50个好友
        JLabel[] jlb = new JLabel[50];

        for (int i = 0; i < jlb.length; i++) {
            jlb[i] = new JLabel(i + 1 + "", new ImageIcon("images/qq/mm.jpg"), JLabel.LEFT);
            jlb[i].addMouseListener(this);
            jphy2.add(jlb[i]);
        }

        jphy3 = new JPanel(new GridLayout(2, 1));
        //把两个按钮加入到jphy3
        jphy3.add(jphy_jb2);
        jphy3.add(jphy_jb3);


        jsp1 = new JScrollPane(jphy2);

        jphy1.add(jphy_jb1, "North");
        jphy1.add(jsp1, "Center");
        jphy1.add(jphy3, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jphy_jb2) {
            cl.show(this.getContentPane(), "2");
        } else if (e.getSource() == jpmsr_jb1) {
            cl.show(this.getContentPane(), "1");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //响应用户双击的事件，并得到好友的编号
        if (e.getClickCount() == 2) {
            //得到该好友的编号
            String friendNo=((JLabel)e.getSource()).getText();
//            System.out.println("你希望和 " + friendNo + " 聊天");
            qqChat qqChat = new qqChat(owner, friendNo);
            Thread t = new Thread(qqChat);
            t.start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jl = (JLabel) e.getSource();
        jl.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jl = (JLabel) e.getSource();
        jl.setForeground(Color.black);
    }
}























