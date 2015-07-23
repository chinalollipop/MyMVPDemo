package com.example.daniel.mymvpdemo.model.impl;

import com.example.daniel.mymvpdemo.presenter.IUserLoginListener;
import com.example.daniel.mymvpdemo.model.IUserModel;

/**
 * Created by daniel on 2015/7/10.
 */
public class UserModelImpl implements IUserModel {

    @Override
    public void login(String userName, String userPsw, IUserLoginListener loginListener) {
/*
        if(TextUtils.isEmpty(userName)){
            loginListener.loginNameFail(userName);
            return;
        }

        if(TextUtils.isEmpty(userPsw)){
            loginListener.loginPswFail(userName);
            return;
        }*/
        //此处添加网络验证部分逻辑

        if("123".equals(userName)&&"qwe".equals(userPsw)){
            loginListener.loginSuccess();
        }else{
            loginListener.loginFail();
        }
    }
}
