package com.example.noone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        final int SPLASH_SCREEN_DISPLAY_LENGTH=2000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent mainIntent=new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(mainIntent);
                finish();
            }
        },SPLASH_SCREEN_DISPLAY_LENGTH);
    }
}
