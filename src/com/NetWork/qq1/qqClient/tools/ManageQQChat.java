package com.NetWork.qq1.qqClient.tools;

import com.NetWork.qq1.qqClient.view.*;

import java.util.HashMap;

/**
 * Created by thinkpad on 2018/4/6.
 * <p>
 * 这是一个管理用户聊天界面的类
 */
public class ManageQQChat {

    private static HashMap hm = new HashMap<String, qqChat>();

    //加入
    public static void addQQChat(String loginIdAnFriendId, qqChat qqChat)
    {
        hm.put(loginIdAnFriendId, qqChat);
    }

    //取出
    public static qqChat getQQChat(String loginIdAnFriendId)
    {
        return (qqChat) hm.get(loginIdAnFriendId);
    }
}
