package com.example.shanks.util;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by shanks on 14/11/26.
 * 新建自己的application 可以随时获取content
 */
public class MyApplication extends LitePalApplication {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
