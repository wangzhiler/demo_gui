package com.NetWork.qq1.qqClient.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.NetWork.qq1.common.*;


/**
 * Created by thinkpad on 2018/3/29.
 * 这是客户端连接服务器的后台
 */
public class qqClientConServer {

    //发送第一次请求
    public boolean sendLoginInfoToServer(Object o) {
        boolean b=false;
        try {
            Socket s = new Socket("127.0.0.1", 9999);

            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);
            //会返回一个结果
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Message ms=(Message)ois.readObject();
            if (ms.getMessageType().equals("1")) {
                b= true;
            } else {
                b= false;
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
