package com.ldlywt.hibase.base;

import android.view.View;

/**
 * @Description MVP之V层 是所有VIEW的基类，其他类可以继承该类
 */
public interface IBaseView<T> {

    /**
     * @description 全局的显示加载框
     */
    void showLoading();

    /**
     * @description 全局的显示加载框
     */
    void showLoading(CharSequence message);
    /**
     * @description 全局的显示加载框
     */
    void showLoading(String msg, int progress);
    /**
     * @description 全局的隐藏加载框
     */
    void hideLoading();
    /**
     * @description 全局消息展示
     */
    void showToast(String msg);

    /**
     * @description 当前fragment是否有效
     */
    boolean isActive();

    /**
     * 显示空数据布局
     */
    void showNullLayout();

    /**
     * 隐藏空数据布局
     */
    void hideNullLayout();

    /**
     * 显示异常布局
     * @param listener
     */
    void showErrorLayout(View.OnClickListener listener);

    void hideErrorLayout();
}