package com.ldlywt.framedemo;

import android.app.Application;

import com.ldlywt.hibase.lce.PageManager;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@gmail.com
 *     time   : 2017/09/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PageManager.initInApp(getApplicationContext(),R.layout.pager_empty,R.layout.pager_loading,R.layout.pager_error);
    }
}
