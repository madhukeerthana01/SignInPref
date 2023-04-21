package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, number;
    Button signin;
    SharedPreferences sharedPreferences;
    public static final String SHARED_PREF_NAME = "My_Pref";
    public static final String KEY_NAME = "Name";
    public static final String KEY_NUMBER = "Number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        number = findViewById(R.id.number);
        signin = findViewById(R.id.signin);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().length()==0){
                    username.setError("Enter Name");
                } else if (number.getText().length()==0) {
                    number.setError("Enter Number");
                }
                else {
                    editor.putString(KEY_NAME,username.getText().toString());
                    editor.putString(KEY_NUMBER,number.getText().toString());
                    Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);

                }
                {
                }
            }
        });

    }
}