package com.example.login_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);




        Button signup = findViewById(R.id.signup);
        TextView login = findViewById(R.id.login);
        TextView googlebutton  = findViewById(R.id.googlebutton);
        TextView facebook = findViewById(R.id.facebook);
        EditText username = findViewById(R.id.username);
        EditText emailaddress = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login_Actvity.class));
                finish();
            }
        });
        googlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login_Actvity.class));
                finish();
            }
        });   facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login_Actvity.class));
                finish();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!username.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailaddress.getText().toString()).matches()
                        && password.getText().toString().length()>4)
                {

                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("username",username.getText().toString());
                    editor.putString("email",emailaddress.getText().toString());
                    editor.putString("password",password.getText().toString());
                    editor.commit();
                    Toast.makeText(Registration_Activity.this, "User successfully Created ", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getApplicationContext(), Login_Actvity.class));
                    finish();

                }
                else if (username.getText().toString().isEmpty())
                {
                    username.setError("Please Enter Name ");
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(emailaddress.getText().toString()).matches())
                {
                    emailaddress.setError("Please Enter Valid ");
                }
                else if (password.getText().toString().length()>4)
                {
                    emailaddress.setError("password minimum 4 digit ");
                }
            }
        });
    }
}