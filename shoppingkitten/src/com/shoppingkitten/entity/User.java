package com.shoppingkitten.entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/6/17.
 */
public class User implements Serializable {
    private int uid;
    private String account;
    private String pwd;

    public User(int uid, String account, String pwd) {
        this.uid = uid;
        this.account = account;
        this.pwd = pwd;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
