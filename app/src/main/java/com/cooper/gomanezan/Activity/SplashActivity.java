package com.cooper.gomanezan.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.cooper.gomanezan.R;

public class SplashActivity extends BaseActivity {
    ProgressBar CheckInternetProgressBar;
    //Todo:check network connection
    //todo:check db Changes in Github
    @Override
    public void setupElements() {
        setContentView(R.layout.activity_splash);
        CheckInternetProgressBar=(ProgressBar)findViewById(R.id.splashactivity__chrck_progressbar);
    }

    @Override
    public void setupToolbar() {

    }

    @Override
    public void loadStaticData() {
        Handler handdler=new Handler();
        //some elements dont need get somthing or check somethings. :)

        handdler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(intent);
                finish();
            }
        },3000);

    }

    @Override
    public void loadDynamicData(boolean auto_load_data) {

    }

    @Override
    public void setupElementsWithData(boolean auto_load_data) {

    }

    @Override
    public void setupOnClick() {

    }

    @Override
    public void setupListener() {

    }
}
