package com.NetWork.qq1.qqClient.view;

import com.NetWork.qq1.common.Message;
import com.NetWork.qq1.qqClient.model.qqClientConServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;



/**
 * Created by thinkpad on 2018/3/29.
 *
 * 这是与好友聊天的界面
 * 因为客户端，要处于读取的状态，依次我们把它们做成一个线程
 *
 */
public class qqChat extends JFrame implements ActionListener,Runnable{

    JTextArea jta;
    JTextField jtf;
    JButton jb;
    JPanel jp;
    String ownerId;
    String friendId;

    public static void main(String[] args) {
//        qqChat qqChat = new qqChat("2");
    }

    public qqChat(String ownerId, String friendNo) {
        this.ownerId = ownerId;
        this.friendId = friendNo;
        jta = new JTextArea();
        jtf = new JTextField(15);
        jb = new JButton("发送");
        jb.addActionListener(this);
        jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);

        this.add(jta, "Center");
        this.add(jp, "South");

        this.setTitle(ownerId+"你正在和"+friendNo+"聊天");

        this.setIconImage((new ImageIcon("images/qq/qq.gif").getImage()));
        this.setSize(300, 200);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            //如果用户点击了发送按钮
            Message m = new Message();
            m.setSender(this.ownerId);
            m.setGetter(this.friendId);
            m.setCon(jtf.getText());
            m.setSenTime(new Date().toString());
            //发送给服务器
            try {
                ObjectOutputStream oos = new ObjectOutputStream(qqClientConServer.s.getOutputStream());
                oos.writeObject(m);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //读取 读不到就等待
                ObjectInputStream ois = new ObjectInputStream(qqClientConServer.s.getInputStream());

                Message m = (Message) ois.readObject();

                //显示
                String info = m.getSender() + " 对 " + m.getGetter() + " 说：" + m.getCon() + "\r\n";
                this.jta.append(info);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}














