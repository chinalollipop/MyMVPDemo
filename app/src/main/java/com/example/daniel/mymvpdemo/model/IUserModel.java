package com.example.daniel.mymvpdemo.model;

import com.example.daniel.mymvpdemo.presenter.IUserLoginListener;

/**
 * Created by daniel on 2015/7/10.
 */
public interface IUserModel {
    public void login(String userName,String userPsw,IUserLoginListener loginListener);
}
