package com.starktech.androidwebview.jsbridge;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class JSInterface extends Object {

    private Context mContext;
    private static final String TAG = "JSInterface";

    public JSInterface(Context context) {
        mContext = context;
    }


    private JSBridge mJSBridge;

    public interface JSBridge {
        void sendMsg(String msg);
    }

    public void setJSBridge(JSBridge JSBridge) {
        mJSBridge = JSBridge;
    }

    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void sendMsg(String msg) {
//        Log.i(TAG, "JS调用了Android的hello方法" + msg);
//        Toast.makeText(mContext, "JS调用了Android的hello方法" + msg, Toast.LENGTH_SHORT).show();
        //为了方便拿到上下文和ui组件,写一个回调接口。
        mJSBridge.sendMsg(msg);
    }

}
