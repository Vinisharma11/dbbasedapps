package com.example.user.loginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class userdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
        TextView TXT=(TextView) findViewById(R.id.TEXTVIEW);

        SharedPreferences preferences = getSharedPreferences("myprefs",MODE_PRIVATE);
        String display = preferences.getString("display"," ");
        TextView displayInfo =(TextView) findViewById(R.id.textView3);
        displayInfo.setText(display);

        Button btn= findViewById(R.id.logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"LOGGING OUT",Toast.LENGTH_SHORT).show();
                Intent it= new Intent(userdetails.this,MainActivity.class);
                startActivity(it);
            }
        });

    }
}
