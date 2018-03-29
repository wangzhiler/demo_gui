package com.NetWork.ObjectStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/29.
 */
public class MyServer {
    public static void main(String[] args) {
        MyServer myServer = new MyServer();
    }

    public MyServer() {
        try {
            ServerSocket ss = new ServerSocket(3456);
            Socket s = ss.accept();
            //以对象流方式读取(假设客户端发的是User的一个对象)
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            User u = (User) ois.readObject();

            System.out.println("从客户端接收到 Name：" + u.getName() + "\n Pass:" + u.getPass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
