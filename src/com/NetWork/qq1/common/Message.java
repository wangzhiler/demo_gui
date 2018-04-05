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

    private String sender;
    private String getter;
    private String con;
    private String senTime;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getSenTime() {
        return senTime;
    }

    public void setSenTime(String senTime) {
        this.senTime = senTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
