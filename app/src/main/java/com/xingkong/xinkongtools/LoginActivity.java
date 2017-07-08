/**
 * LoginActivity 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xingkong.xinkong_library.callback.XKBaseObserver;
import com.xingkong.xinkongtools.bean.LoginModel;
import com.xingkong.xinkongtools.bean.UserDao;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-07 11:02
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mEtPassword = findViewById(R.id.et_password);
        mEtUserName = findViewById(R.id.et_userName);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String password = mEtPassword.getText().toString();
        String userName = mEtUserName.getText().toString();
        UserDao userDao = new UserDao();
        userDao.setPwd(password);
        userDao.setUserName(userName);
        Log.e("hxl", userDao.toString());
        LoginModel.getInstance().execute(userDao, new XKBaseObserver<UserDao>() {
            @Override
            protected void onBaseNext(UserDao data) {
                Log.e("hxl", data.getPwd());
            }
        });
    }


}
