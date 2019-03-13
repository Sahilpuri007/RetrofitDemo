package com.android.example.retrofitdemo.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.example.retrofitdemo.R;

public class SplashScreen extends AppCompatActivity {

    public static final long SPLASH_SCREEN_TIME=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,ShowCountriesActivity.class);
                startActivity(intent);
            }
        },SPLASH_SCREEN_TIME);

    }
}
