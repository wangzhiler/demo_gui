package com.NetWork.ObjectStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/29.
 */
public class MyClient {

    public static void main(String[] args) {
        MyClient myClient = new MyClient();
    }

    public MyClient() {
        try {
            Socket s = new Socket("127.0.0.1", 3456);
            //通过ObjectOutputStream给服务器传送对象
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            User u = new User();
            u.setName("aaa");
            u.setPass("123");
            oos.writeObject(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
