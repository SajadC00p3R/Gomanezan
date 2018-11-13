package com.cooper.gomanezan.Activty;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.cooper.gomanezan.R;

public class SplashActivity extends BaseActivity {


    @Override
    public void setupElements() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void setupToolbar() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(intent);
                finish();
            }
        },3000);
    }

    @Override
    public void loadStaticData() {

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
