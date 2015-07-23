package com.example.daniel.mymvpdemo.model.entity;

/**
 * Created by daniel on 2015/7/10.
 */
public class User {
    private String UserName;

    private String UserPsw;

    public String getUserPsw() {
        return UserPsw;
    }

    public void setUserPsw(String userPsw) {
        UserPsw = userPsw;
    }

    public String getUserName() {
        return UserName;

    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
