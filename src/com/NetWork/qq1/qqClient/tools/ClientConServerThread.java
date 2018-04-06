package com.NetWork.qq1.qqClient.tools;

import com.NetWork.qq1.common.Message;
import com.NetWork.qq1.qqClient.view.qqChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/4/5.
 *
 * 这是客户端和服务器端保持通讯的线程
 */
public class ClientConServerThread extends Thread{

    private Socket s;

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    //构造函数
    public ClientConServerThread(Socket s) {
        this.s=s;
    }

    public void run() {
        while (true) {
            //不停的读取从服务器端发来的消息
            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message m = (Message) ois.readObject();
                System.out.println("读取到从服务端发来的消息" + m.getSender() + " 给 " + m.getGetter() + " 内容 "
                        + m.getCon());

                //把从服务器获得的消息，显示到该显示的聊天界面
                qqChat qqChat = ManageQQChat.getQQChat(m.getGetter() + " " + m.getSender());
                //显示
                qqChat.showMessage(m);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
