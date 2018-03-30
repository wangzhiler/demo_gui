package com.NetWork.qq1.qqClient.model;
import com.NetWork.qq1.common.*;

/**
 * Created by thinkpad on 2018/3/31.
 */
public class qqClientUser {

    public boolean checkUser(User u) {
        return new qqClientConServer().sendLoginInfoToServer(u);
    }
}
