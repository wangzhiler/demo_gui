package com.NetWork.qq1.qqClient.model;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by thinkpad on 2018/3/29.
 * 这是客户端连接服务器的后台
 */
public class MyQQClientConServer {

    public MyQQClientConServer() {
        try {
            Socket s = new Socket("127.0.0.1", 9999);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
