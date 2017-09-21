package com.ldlywt.hibase.mvp;

/**
 * @Description MVP的P层
 * @Author ydc
 * @CreateDate 2016/10/10
 * @Version 1.0
 */
public interface IBasePresenter<T> {

    /**
     * 关联P与V（绑定，VIEW销毁适合解绑）
     */
    void attachView(T view);

    /**
     * 取消关联P与V（防止内存泄漏）
     */
    void detachView();

    //在activity的onResume调用
    void onResume();

    //获得view
    T getView();

    /**
     * RX订阅
     */
    void subscribe();

    /**
     * RX取消订阅
     */
    void unsubscribe();

}
