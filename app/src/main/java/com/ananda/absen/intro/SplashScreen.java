package com.ananda.absen.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ananda.absen.R;

public class SplashScreen extends AppCompatActivity {
    private int time_loading = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent splash = new Intent(SplashScreen.this,Pengenalan1Activity.class);
                startActivity(splash);
                finish();
            }
        },time_loading);
    }
}
