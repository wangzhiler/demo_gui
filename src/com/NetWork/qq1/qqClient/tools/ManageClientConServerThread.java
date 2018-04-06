package com.NetWork.qq1.qqClient.tools;

import java.util.HashMap;

/**
 * Created by thinkpad on 2018/4/5.
 *
 * 管理客户端和服务器保持通讯的线程类
 */
public class ManageClientConServerThread {

    private static HashMap hm = new HashMap<String, ClientConServerThread>();

    //把创建好的ClientConServerThread放入到hm
    public static void addClientConServerThread(String qqId, ClientConServerThread ccst) {
        hm.put(qqId, ccst);
    }

    //可以通过qqId取得该线程
    public static ClientConServerThread getClientConServerThread(String qqId) {
        return (ClientConServerThread) hm.get(qqId);
    }
}
