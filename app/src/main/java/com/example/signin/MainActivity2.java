package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
TextView txt, nametxt, numbertxt;
Button logout;
SharedPreferences sharedPreferences;
    public static final String SHARED_PREF_NAME = "My_Pref";
    public static final String KEY_NAME = "Name";
    public static final String KEY_NUMBER = "Number";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.txt);
        nametxt = findViewById(R.id.nametxt);
        numbertxt = findViewById(R.id.numbertxt);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String stringName = sharedPreferences.getString(KEY_NAME, null);
        String stringNumber = sharedPreferences.getString(KEY_NUMBER, null);
        nametxt.setText("Name" +stringName);
        numbertxt.setText("Mobile Number"+ stringNumber);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(MainActivity2.this, "Logged out Successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}