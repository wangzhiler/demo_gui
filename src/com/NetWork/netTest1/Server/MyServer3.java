package com.NetWork.netTest1.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/25.
 */
public class MyServer3 extends JFrame implements ActionListener{


    JTextArea jta=null;
    JTextField jtf=null;
    JButton jb=null;
    JScrollPane jsp=null;
    JPanel jp1=null;
    //把信息发给客户端的对象
    PrintWriter pw=null;

    public static void main(String[] args) {
        MyServer3 myServer3 = new MyServer3();
    }

    public MyServer3()
    {
        jta = new JTextArea();
        jsp = new JScrollPane(jta);
        jtf = new JTextField(10);
        jb = new JButton("发送");
        jb.addActionListener(this);

        jp1 = new JPanel();
        jp1.add(jtf);
        jp1.add(jb);
        this.add(jsp, "Center");
        this.add(jp1, "South");

        this.setTitle("qq简易聊天Server");

        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        try {
            ServerSocket ss = new ServerSocket(9988);
            //等待客户端连接
            Socket s = ss.accept();

            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            pw = new PrintWriter(s.getOutputStream(), true);
            //读取从客户端发来的信息
            while (true) {
                String info = br.readLine();
                jta.append("Client: "+info+"\r\n");

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jb) {
            //把服务器在jtf里写的内容发送给Client
            String info = jtf.getText();
            jta.append("Server: "+info+"\r\n");
            pw.println(info);
            //清空输入框内容
            jtf.setText("");

        }
    }
}
