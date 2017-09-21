package com.ldlywt.framedemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ldlywt.hibase.lce.PageManager;

import java.util.Random;

public class LceViewActivity extends AppCompatActivity {

    PageManager pageStateManager;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lce_view);

        pageStateManager = PageManager.init(this, "空空快快快快快快快快快快快快", true, new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LceViewActivity.this, "点击重试了...", Toast.LENGTH_LONG).show();
                doNet();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        doNet();
    }

    private void doNet() {
        pageStateManager.showLoading();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int state = new Random().nextInt(3);
                switch (state) {
                    case 0:
                        pageStateManager.showError("哈哈哈哈哈错误了");
                        break;
                    case 1:
                        pageStateManager.showEmpty();
                        break;
                    case 2:
                        pageStateManager.showContent();
                }

            }
        }, 2000);
    }
}
