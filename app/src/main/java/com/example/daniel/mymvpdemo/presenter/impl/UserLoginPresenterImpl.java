package com.example.daniel.mymvpdemo.presenter.impl;

import android.os.Handler;
import android.text.TextUtils;

import com.example.daniel.mymvpdemo.model.IUserModel;
import com.example.daniel.mymvpdemo.model.impl.UserModelImpl;
import com.example.daniel.mymvpdemo.presenter.IUserLoginListener;
import com.example.daniel.mymvpdemo.view.IUserLoginView;

/**
 * Created by daniel on 2015/7/10.
 */
public class UserLoginPresenterImpl implements IUserLoginListener {


    private IUserModel iUserModel;
    private IUserLoginView iUserLoginView;

    public UserLoginPresenterImpl(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        this.iUserModel = new UserModelImpl();
    }

    private Handler mHandler = new Handler();

    public void login(){
        iUserLoginView.showLoading();

        if(TextUtils.isEmpty(iUserLoginView.getUserName())){
            iUserLoginView.UserNameFail();
            return;
        }

        if(TextUtils.isEmpty(iUserLoginView.getUserPsw())){
            iUserLoginView.UserPswFail();
            return;
        }
        iUserModel.login(iUserLoginView.getUserName(),iUserLoginView.getUserPsw(),this);
    }

    @Override
    public void loginSuccess() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                iUserLoginView.hideLoading();
                iUserLoginView.toNextActivity();
            }
        });
    }

    @Override
    public void loginFail() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                iUserLoginView.hideLoading();
                iUserLoginView.showLoginFail();
            }
        });
    }
}
