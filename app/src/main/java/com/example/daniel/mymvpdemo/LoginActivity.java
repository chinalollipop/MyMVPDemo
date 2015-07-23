package com.example.daniel.mymvpdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.mymvpdemo.presenter.impl.UserLoginPresenterImpl;
import com.example.daniel.mymvpdemo.view.IUserLoginView;

;


public class LoginActivity extends ActionBarActivity implements IUserLoginView {

    EditText edtUserName;
    EditText edtUserPsw;
    Button btnLogin;

    private UserLoginPresenterImpl userLoginPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
    }


    public void loginVerify(View view){
        userLoginPresenter.login();
    }

    private void loadView(){
        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtUserPsw = (EditText) findViewById(R.id.edt_user_psw);
        btnLogin = (Button) findViewById(R.id.btn_login);
        userLoginPresenter = new UserLoginPresenterImpl(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getUserName() {
        return edtUserName.getText().toString().trim();
    }

    @Override
    public String getUserPsw() {
        return edtUserPsw.getText().toString().trim();
    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toNextActivity() {
        Toast.makeText(this,"恭喜您，验证成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFail() {
        Toast.makeText(this,"验证失败，请重试!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UserNameFail() {
        Toast.makeText(this,"对不起，用户名不能为空！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UserPswFail() {
        Toast.makeText(this,"对不起，用户密码不能为空！",Toast.LENGTH_SHORT).show();
    }
}
