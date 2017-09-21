package com.ldlywt.library;

import android.app.Application;
import android.content.Context;

import com.ldlywt.library.constant.SPKeys;
import com.ldlywt.library.download.DownloadRetrofit;
import com.ldlywt.library.http.GlobalRxHttp;
import com.ldlywt.library.http.SingleRxHttp;
import com.ldlywt.library.upload.UploadRetrofit;
import com.ldlywt.library.utils.AppUtils;
import com.ldlywt.library.utils.SPUtils;

import java.util.HashSet;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by allen on 2017/6/22.
 * 网络请求
 */

public class RxNet {
    private static RxNet instance;
    private Application context;            //全局上下文

    public static RxNet getInstance() {
        if (instance == null) {
            synchronized (RxNet.class) {
                if (instance == null) {
                    instance = new RxNet();
                }
            }

        }
        return instance;
    }

    public RxNet init(Application app) {
        context = app;
        return this;
    }

    /** 获取全局上下文 */
    public Context getContext() {
        AppUtils.checkNotNull(context, "please call OkGo.getInstance().init() first in application!");
        return context;
    }



    public GlobalRxHttp config() {
        return GlobalRxHttp.getInstance();
    }


    /**
     * 使用全局参数创建请求
     *
     * @param cls
     * @param <K>
     * @return
     */
    public static <K> K createApi(Class<K> cls) {
        return GlobalRxHttp.createGApi(cls);
    }

    /**
     * 获取单个请求配置实例
     *
     * @return
     */
    public static SingleRxHttp getSInstance() {

        return SingleRxHttp.getInstance();
    }


    /**
     * 下载文件
     *
     * @param fileUrl
     * @return
     */
    public static Observable<ResponseBody> downloadFile(String fileUrl) {
        return DownloadRetrofit.downloadFile(fileUrl);
    }

    /**
     * 上传单张图片
     *
     * @param uploadUrl
     * @param filePath
     * @return
     */
    public static Observable<ResponseBody> uploadImg(String uploadUrl, String filePath) {
        return UploadRetrofit.uploadImg(uploadUrl, filePath);

    }

    /**
     * 获取Cookie
     *
     * @return
     */
    public static HashSet<String> getCookie() {
        HashSet<String> preferences = (HashSet<String>) SPUtils.get(SPKeys.COOKIE, new HashSet<String>());
        return preferences;
    }

}
