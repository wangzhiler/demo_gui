package com.NetWork.qq1.qqServer.model;

import com.NetWork.qq1.common.Message;
import com.NetWork.qq1.common.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/29.
 * QQ服务器 ，它在监听等待某个qq客户端，来连接
 */
public class MyQQServer {

    public MyQQServer() {
        try {
            //在9999监听
            System.out.println("我是服务器，在9999监听");
            ServerSocket ss = new ServerSocket(9999);
            //阻塞，等待连接
            while (true) {
                Socket s = ss.accept();

                //接受客户端发来的消息
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                User u = (User) ois.readObject();

                Message m=new Message();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                if (u.getPasswd().equals("123456")) {
                    //返回一个成功登录的信息报
                    m.setMessageType("1");
                    oos.writeObject(m);

                    //这里就单开一个线程，该线程与该客户保持通讯
                    ServerConClientThread scct = new ServerConClientThread(s);
                    ManageClientThread.addClientThread(u.getUserId(),scct);
                    //启动与该客户端通信的线程
                    scct.start();

                } else {
                    m.setMessageType("2");
                    oos.writeObject(m);
                    //关闭连接
                    s.close();
                }
            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
