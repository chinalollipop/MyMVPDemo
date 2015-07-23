package com.example.daniel.mymvpdemo.view;

/**
 * Created by daniel on 2015/7/10.
 */
public interface IUserLoginView {

    public  String getUserName();
    public  String getUserPsw();
    public void UserNameFail();
    public void UserPswFail();
    public void  showLoading();
    public void  hideLoading();
    public void  toNextActivity();
    public void  showLoginFail();

}
