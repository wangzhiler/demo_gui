package com.NetWork.qq1.qqServer.model;

import com.NetWork.qq1.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * Created by thinkpad on 2018/3/31.
 *
 * function: 是服务器和某个客户端的通信线程
 */
public class ServerConClientThread extends Thread{
    Socket s;

    public ServerConClientThread(Socket s) {
        //把服务器和该客户端的连接赋给s
        this.s=s;
    }

    public void run() {
        while (true) {
            //这里该线程就可以接受客户端的信息

            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message m = (Message) ois.readObject();

                System.out.println(m.getSender() + " 给 " + m.getGetter() + " 说： " + m.getCon());

                //一会完成转发
                //取得接收人的通信线程
                ServerConClientThread sc = ManageClientThread.getClientThread(m.getGetter());
                ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
                oos.writeObject(m);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
