package com.adgvit.iosfusion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;

public class splashScreen extends AppCompatActivity {
    String name ,registration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        SharedPreferences sharePref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        name = sharePref.getString("userName",null);
        registration = sharePref.getString("userno",null);
        CountDownTimer countDownTimer= new CountDownTimer(2000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
            }
            @Override
            public void onFinish()
            {
                if (name==null && registration==null)
                {
                    Intent sIntent = new Intent(splashScreen.this, Login.class);
                    startActivity(sIntent);
                    splashScreen.this.finish();
                }
                else
                {
                    Intent pIntent = new Intent(splashScreen.this,MainActivity.class);
                    startActivity(pIntent);
                    splashScreen.this.finish();
                }
            }
        };
        countDownTimer.start();
    }
}