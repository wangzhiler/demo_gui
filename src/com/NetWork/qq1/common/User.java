package com.NetWork.qq1.common;

import java.io.Serializable;

/**
 * Created by thinkpad on 2018/3/29.
 */
public class User implements Serializable{
    private String userId;
    private String passwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
