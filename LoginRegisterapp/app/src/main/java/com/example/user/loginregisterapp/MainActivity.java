package com.example.user.loginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText email = findViewById(R.id.email);

       final EditText password = findViewById(R.id.password);

        TextView loginsignup= findViewById(R.id.loginsignup);

        Button login= findViewById(R.id.Login);

        Button signup=findViewById(R.id.signup);

        Button reset=findViewById(R.id.rst);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String passwor = password.getText().toString();

                SharedPreferences preferences = getSharedPreferences("myprefs", MODE_PRIVATE);

                String userdetails = preferences.getString(username + passwor +"data" ,"username or password is incorrect");
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("display",userdetails);
                editor.commit();

                if(email.getText().toString().length() == 0 )
                    email.setError( "FIRST USERNAME IS REQUIRED" );
                if(password.getText().toString().length() == 0 )
                    password.setError( "FIRST PASSWORD IS REQUIRED" );

                else {
                    Toast.makeText(getApplicationContext(),"LOGGING IN",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, userdetails.class);
                    startActivity(intent);

                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(MainActivity.this,signupage.class);
                startActivity(j);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText("");
                password.setText("");

            }
        });

    }
}
