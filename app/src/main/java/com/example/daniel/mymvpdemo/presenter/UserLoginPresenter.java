package com.example.daniel.mymvpdemo.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.example.daniel.mymvpdemo.model.IUserModel;
import com.example.daniel.mymvpdemo.model.impl.UserModelImpl;
import com.example.daniel.mymvpdemo.view.IUserLoginView;

/**
 * Created by daniel on 2015/7/10.
 */
public class UserLoginPresenter {


    private IUserModel iUserModel;
    private IUserLoginView iUserLoginView;

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
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
            iUserLoginView.UserNameFail();
            return;
        }

        iUserModel.login(iUserLoginView.getUserName(),iUserLoginView.getUserPsw(),
                new IUserLoginListener() {
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

                   /* @Override
                    public void loginNameFail(String string) {
                        iUserLoginView.UserNameFail();
                    }

                    @Override
                    public void loginPswFail(String string) {
                        iUserLoginView.UserPswFail();
                    }*/
                }
        );
    }

}
