package com.example.login_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Actvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actvity);


        TextView signup = findViewById(R.id.signuplg);
        EditText email = findViewById(R.id.emaillg);
        EditText password = findViewById(R.id.lgpassword);
        Button signin = findViewById(R.id.signin);

        SharedPreferences preferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String emailsave = preferences.getString("email",null);
        String passwordsave = preferences.getString("password",null);
        Toast.makeText(this, "Email : "+emailsave+"\nPassword :"+passwordsave, Toast.LENGTH_SHORT).show();


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailsave.equals(email.getText().toString()) && passwordsave.equals(password.getText().toString()))
                {
                    Toast.makeText(Login_Actvity.this, "User Login  successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Registration_Activity.class));
                finish();
            }
        });
    }
}