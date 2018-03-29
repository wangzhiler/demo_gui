package com.NetWork.netTest1.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/25.
 * 这是一个客户端程序，可以连接服务器
 */
public class MyClient1 {

    public static void main(String[] args) {
        MyClient1 myClient1 = new MyClient1();
    }

    public MyClient1() {
        try {
            //Socket()就是去连接某个服务器端，127.0.0.1表示服务器的ip地址
            Socket s = new Socket("127.0.0.1", 9999);

            //如果s连接成功，就可以发送数据给服务器
            //我们通过pw向s写数据，true表示及时刷新
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println("你好吗，我是客户端");

            //接受server
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String response = br.readLine();

            System.out.println("我是Client，收到了："+response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
