package com.ldlywt.hibase.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ldlywt.hibase.bus.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@gmail.com
 *     time   : 2017/09/19
 *     desc   : 使用EventBus时在该Activity添加注解 @BindEventBus
 *     version: 1.0
 * </pre>
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{
    public ProgressDialog progressDialog;
    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        initBind();
        initViews(savedInstanceState);
        initData();
        mActivity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
        ButterKnife.unbind(mActivity);
    }

    protected void initBind() {
        ButterKnife.bind(mActivity);
    }

    protected int getLayoutId() {
        return 0;
    }

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initData();

    /**
     * 打开一个Activity 默认 不关闭当前activity
     */
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            finish();
        }
    }

    @Override
    public void showLoading() {
        if (progressDialog != null) {
            progressDialog = new ProgressDialog(mActivity);
        }
        progressDialog.setMessage("加载中...");
        progressDialog.show();
    }

    @Override
    public void showLoading(CharSequence message) {
        if (progressDialog != null) {
            progressDialog = new ProgressDialog(mActivity);
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void showLoading(String msg, int progress) {

    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void showNullLayout() {

    }

    @Override
    public void hideNullLayout() {

    }

    @Override
    public void showErrorLayout(View.OnClickListener listener) {

    }

    @Override
    public void hideErrorLayout() {

    }
}
