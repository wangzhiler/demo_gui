package com.NetWork.qq1.qqClient.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.NetWork.qq1.common.*;
import com.NetWork.qq1.qqClient.tools.ClientConServerThread;
import com.NetWork.qq1.qqClient.tools.ManageClientConServerThread;


/**
 * Created by thinkpad on 2018/3/29.
 * 这是客户端连接服务器的后台
 */
public class qqClientConServer {

    public Socket s;

    //发送第一次请求
    public boolean sendLoginInfoToServer(Object o) {
        boolean b=false;
        try {
            System.out.println("发送第一次请求");
            s = new Socket("127.0.0.1", 9999);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);
            //会返回一个结果
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Message ms=(Message)ois.readObject();

            //这里就是验证用户登录的地方
            if (ms.getMessageType().equals("1")) {
                //就创建一个该qq号和服务器端保持通讯连接的线程
                ClientConServerThread ccst = new ClientConServerThread(s);
                //启动该通讯线程
                ManageClientConServerThread.addClientConServerThread(((User)o).getUserId(),ccst);

                b = true;
            } else {
                b = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return b;
    }

    public void SendInfoToServer(Object o) {
        try {
            Socket s = new Socket("127.0.0.1", 9999);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
