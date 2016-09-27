package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lenovo.myapplication.base.Data;

/**
 * Created by lenovo on 2016-09-27.
 */

public class MyActivity extends Activity {
    public Data app;
    public static MyActivity Instance;
    public static android.content.Context Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        app = (Data) getApplication();
        Instance = this;
        Context = getBaseContext();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
//            Data.NEEDSALESORDERNOTIFY = false;
        }

//        if (hasFocus) {
//            app.NEEDSALESORDERNOTIFY = true;
//            app.ServiceStop();
//        } else {
//            if (app.NEEDSALESORDERNOTIFY)
//                app.ServiceStart();
//        }
    }

    /**
     * 确认退出
     */
    @Override
    public void onBackPressed() {
//        app.showFinishConfirm(MyActivity.this);
        // super.onBackPressed();
    }

    protected void backRun() {
//        app.ServiceStart();

        PackageManager packageManager = getPackageManager();
        ResolveInfo homeInf = packageManager.resolveActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0);
        ActivityInfo activityInfo = homeInf.activityInfo;
        Intent startIntent = new Intent(Intent.ACTION_MAIN);
        startIntent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        startActivitySafely(startIntent);
    }

    private void startActivitySafely(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        } catch (SecurityException e) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        }
    }
}
