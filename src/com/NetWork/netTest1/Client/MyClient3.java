package com.NetWork.netTest1.Client;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/25.
 */
public class MyClient3 extends JFrame implements ActionListener{

    JTextArea jta=null;
    JTextField jtf=null;
    JButton jb=null;
    JScrollPane jsp=null;
    JPanel jp1=null;

    PrintWriter pw=null;

    public static void main(String[] args) {
        MyClient3 myServer3 = new MyClient3();
    }

    public MyClient3()
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

        this.setTitle("qq简易聊天Client");

        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            Socket s = new Socket("127.0.0.1", 9988);

            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            pw = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                //不停的读取从服务器发来的信息
                String info = br.readLine();
                jta.append("Server: "+info+"\r\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            String info = jtf.getText();
            jta.append("Client: "+info+"\r\n");
            pw.println(info);
            jtf.setText("");

        }


    }
}
