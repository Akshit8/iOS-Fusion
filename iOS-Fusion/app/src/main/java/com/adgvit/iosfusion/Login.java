package com.adgvit.iosfusion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;


public class Login extends AppCompatActivity
{
    EditText userName;
    EditText userRegNo;
    ImageButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.nameField);
        userRegNo = findViewById(R.id.regNoField);
        login =findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(userName.getText().toString()==null||userRegNo.getText().toString()==null)
                {
                    Toast.makeText(getApplicationContext(),"Enter Valid Details",Toast.LENGTH_LONG).show();
                }
                else if (!check(userRegNo.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter Valid Details",Toast.LENGTH_LONG).show();
                }
                else {
                    SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", userName.getText().toString());
                    editor.putString("userno", userRegNo.getText().toString().toUpperCase());
                    editor.commit();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public boolean check(String target)
    {
        String checker="1[0-9][A-Za-z]{3}[0-9]{4}";
        return Pattern.compile(checker).matcher(target).matches();
    }
}