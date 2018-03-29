package com.NetWork.qq1.qqServer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            ServerSocket ss = new ServerSocket(9999);
            //阻塞，等待连接
            Socket s = ss.accept();

            //接受客户端发来的消息
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String info = br.readLine();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
