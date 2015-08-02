package com.daxueoo.shopnc.ui.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daxueoo.shopnc.R;
import com.daxueoo.shopnc.sdk.Shopnc;
import com.daxueoo.shopnc.utils.ConstUtils;

/**
 * Created by user on 15-8-2.
 */
public class LoginActivity extends BaseActivity {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private String TAG = "LoginActivity";
    private TextView tv_title;
    private TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewsById();
        initView();
    }

    private void initView() {
        tv_title.setText(R.string.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, et_username.getText().toString());
                Log.e(TAG, et_password.getText().toString());
                //发送post请求
                Shopnc.login(LoginActivity.this, et_username.getText().toString(), et_password.getText().toString(), ConstUtils.client_type);

                //跳转Activity
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainTabActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViewsById() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        tv_title = (TextView) findViewById(R.id.titlebar_tv);
        tv_register = (TextView) findViewById(R.id.tv_register);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

}
