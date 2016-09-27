package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
/**
 * Created by lenovo on 2016-09-27.
 */

public class LoginActivity extends Activity {
    private EditText tbxUserName;
    private EditText tbxPassword;
    private CheckBox ckbRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        tbxUserName=(EditText) findViewById(R.id.tbxUserName);
        tbxPassword = (EditText) findViewById(R.id.tbxPassword);
        ckbRememberMe = (CheckBox) findViewById(R.id.ckbRememberMe);

        //静态赋值
        tbxUserName.setText("admin");
        tbxPassword.setText("1");
        //登录按钮
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tbxUserName.getText().toString().equals("admin")
                        &&
                        tbxPassword.getText().toString().equals("1")
                        ){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                }
            }
        });
    }
    /* 检查网络设置 */
    public boolean CheckNetworkState() {
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo.State mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        //如果3G、wifi、2G等网络状态是连接的，则退出，否则显示提示信息进入网络设置界面
        if (mobile == NetworkInfo.State.CONNECTED || mobile == NetworkInfo.State.CONNECTING)
            flag = true;
        if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING)
            flag = true;
        return flag;
    }

}
