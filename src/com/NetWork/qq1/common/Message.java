package com.NetWork.qq1.common;

import java.io.Serializable;

/**
 * Created by thinkpad on 2018/3/29.
 *
 * messageType =1 表示登录成功
 * messageType =2 表示登录失败
 * messageType =3 表示是普通的消息包
 *
 */
public class Message implements Serializable{
    private String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
