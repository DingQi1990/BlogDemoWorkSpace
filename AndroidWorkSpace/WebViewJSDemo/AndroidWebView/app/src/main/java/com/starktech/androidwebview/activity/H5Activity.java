package com.starktech.androidwebview.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.starktech.androidwebview.R;
import com.starktech.androidwebview.jsbridge.JSInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 用原生方法实现Android和webview之间的相互通信
 */
public class H5Activity extends AppCompatActivity implements JSInterface.JSBridge {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.msg)
    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);
        ButterKnife.bind(this);

        mWebView.loadUrl("http://192.168.1.109:8080");
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        //绑定接口 然后通过js调用android原生方法
        //js 调用原生的方式1
        JSInterface jsInterface = new JSInterface(this);
        jsInterface.setJSBridge(this);
        mWebView.addJavascriptInterface(jsInterface, "Android_Interface");

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.btn)
    public void click(View v) {
        //在点击事件中调用js中的方法  --在android中调用web中的js方法
        //如何在调用js方法的同时把原声的值 回传回去
        String str = "我叫小明";
        // 第一种调用js中代码的方法
//        mWebView.loadUrl("javascript:beStronger()");
        //第二种调用js中代码的方法,同时传值过去
        mWebView.evaluateJavascript("javascript:beStronger('" + str + "')", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                //此处为 js 返回的结果
                Toast.makeText(H5Activity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void sendMsg(String msg) {
        mTextView.setText(msg);
    }
}
