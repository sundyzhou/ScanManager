package com.igpink.android.app.igpink.net;


import com.igpink.android.app.igpink.utils.Utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Zhiqiang on 2016/3/30.
 */
public class RequestTask {
    private static final String TAG_URL_ = "CurrentRequestUrl";

    public RequestTask() {
    }

    public void request(String url, final OnRequestCompleteListener onRequestCompleteListener){
        Utils.log(TAG_URL_,url);
        RequestParams requestParams = new RequestParams(url);
        requestParams.setConnectTimeout(60000);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onError(ex, isOnCallback);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onCancelled(cex);
                }
            }

            @Override
            public void onFinished() {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onFinished();
                }
            }
        });
    }

    public void request(String url, HashMap<String ,Object> info, final OnRequestCompleteListener onRequestCompleteListener){
        RequestParams requestParams = new RequestParams(url);
        requestParams.setConnectTimeout(60000);
        Iterator<Map.Entry<String ,Object>> iterator = info.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String ,Object> entry = iterator.next();
            requestParams.addParameter(entry.getKey(), entry.getValue());
        }
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onError(ex, isOnCallback);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onCancelled(cex);
                }
            }

            @Override
            public void onFinished() {
                if (onRequestCompleteListener != null){
                    onRequestCompleteListener.onFinished();
                }
            }
        });
    }

    public interface OnRequestCompleteListener{
        void onSuccess(String result);
        void onError(Throwable ex, boolean isOnCallback);
        void onCancelled(Callback.CancelledException cex);
        void onFinished();
    }

}
