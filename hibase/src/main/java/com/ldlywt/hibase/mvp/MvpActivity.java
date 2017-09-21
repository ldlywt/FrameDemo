package com.ldlywt.hibase.mvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/7/8.
 */

public abstract class MvpActivity<V,P extends IBasePresenter<V>> extends AppCompatActivity {

    private P presneter;
    private V view;

    public P getPresneter() {
        return presneter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.presneter == null){
            //创建P层
            this.presneter = createPresneter();
        }

        if (this.view == null){
            //创建V层
            this.view = createView();
        }
        //判定是否为空
        if (this.presneter == null){
            throw new NullPointerException("presneter不能够为空");
        }
        if (this.view == null){
            throw new NullPointerException("view不能够为空");
        }
        //绑定
        this.presneter.attachView(this.view);
    }

    //并不知道具体的P是哪一个实现类，由他的子类决定(BaseActivity子类决定具体类型)
    public abstract P createPresneter();

    //并不知道具体的V是哪一个实现类，由他的子类决定(BaseActivity子类决定具体类型)
    public abstract V createView();

    @Override
    protected void onResume() {
        super.onResume();
        getPresneter().onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presneter.detachView();
    }

}
