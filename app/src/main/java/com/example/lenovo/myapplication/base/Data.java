package com.example.lenovo.myapplication.base;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 数据类 用于操作数据库获取数据等操作
 * Created by lenovo on 2016-09-27.
 */

public class Data extends Application {
    public String UserName="admin";
    public String Password="1";

    public Data(String userName, String password) {
        UserName = userName;
        Password = password;
    }
    /**
    *检查账户的合法性
    **/
    public boolean CheckAountLegitimacy(
            String userName,String password){
        boolean resualt=false;
        if(userName.equals(UserName)
                && password.equals(Password)){
            resualt=true;
        }else{
            resualt=false;
        }
        return resualt;
    }
    /**
     * 消息提示
     * @param message 消息内容
     */
    public void showTips(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("提示̬");
        builder.setMessage(message);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create();
        builder.show();
    }
    /**
     * 打开网络设置
     */
    public void showNetworkSettingTips(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("网络状态");
        builder.setMessage("当前网络不可用，是否设置网络？");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 如果没有网络连接，则进入网络设置界面
                startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create();
        builder.show();
    }
    /**
     * 消息提示
     *
     * @param message 消息内容
     */
    public void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
