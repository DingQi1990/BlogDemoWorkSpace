package com.starktech.androidwebview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.starktech.androidwebview.activity.H52Activity;
import com.starktech.androidwebview.activity.H5Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.bt_go_h5)
//    Button btGoH5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_go_h5)
    public void goH5(View v) {
        startActivity(new Intent(this, H5Activity.class));
    }

    @OnClick(R.id.bt_go_h52)
    public void goH52(View v) {
        startActivity(new Intent(this, H52Activity.class));
    }


}
