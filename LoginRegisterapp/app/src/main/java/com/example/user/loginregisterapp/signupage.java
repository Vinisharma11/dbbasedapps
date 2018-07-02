package com.example.user.loginregisterapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupage);

        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        Button bt3 = findViewById(R.id.register);
        Button bt = findViewById(R.id.reset);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myprefs", MODE_PRIVATE);
                String newUser = name.getText().toString();
                String newphone = phone.getText().toString();
                String newPasswords = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newEmail + newPasswords +"data" , " NAME:" + newUser + "\n EMAIL:"+newEmail + "\n CONTACT:" + newphone);
                editor.commit();
                Toast.makeText(getApplicationContext(),"SUCESSFULLY REGISTERED",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(signupage.this, MainActivity.class);
                startActivity(i);

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                phone.setText("");
                password.setText("");
            }
        });

    }
}
