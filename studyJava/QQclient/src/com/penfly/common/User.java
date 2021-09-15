package com.penfly.common;

import java.io.Serializable;

/**
 * @author  Penflyz
 * @time  2021/8/26 11:09
 */
public class User implements Serializable {
    private String userID;
    private String pwd;

    public User(){}

    public User(String userID, String pwd) {
        this.userID = userID;
        this.pwd = pwd;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}