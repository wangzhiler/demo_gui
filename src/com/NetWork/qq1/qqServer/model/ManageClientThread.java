package com.NetWork.qq1.qqServer.model;

import java.util.HashMap;

/**
 * Created by thinkpad on 2018/4/1.
 * <p>
 * 将服务器得到的每个Socket[和客户端]，保存在HashMap，用客户的id标示该Socket
 */
public class ManageClientThread {

    public static HashMap hm = new HashMap<String, ServerConClientThread>();

    //向hm中添加一个客户端通信线程
    public static void addClientThread(String uid, ServerConClientThread ct) {
        //
        hm.put(uid, ct);
    }

    public static ServerConClientThread getClientThread(String uid) {
        //
        return (ServerConClientThread) hm.get(uid);
    }
}
