package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Handler handler = new Handler(Looper.getMainLooper());
    public static final String SHARED_PREF_NAME = "My_Pref";
    public static final String KEY_NAME = "Name";
    public static final String KEY_NUMBER = "Number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences= getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String stringName = sharedPreferences.getString(KEY_NAME, null);
        String stringNumber = sharedPreferences.getString(KEY_NUMBER, null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ((stringName != null) || (stringNumber != null)) {
                    Intent intent = new Intent(SplashActivity.this,MainActivity2.class);
                    startActivity(intent);

                }
                else {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);

                }
                finish();

            }
        },2000);
    }
}