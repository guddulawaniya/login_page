package com.example.login_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcometext = findViewById(R.id.welcometext);

        SharedPreferences preferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name = preferences.getString("username",null);

        welcometext.setText("Welcome : "+name);
    }
}