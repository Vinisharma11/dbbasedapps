package com.example.user.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button display=(Button)findViewById(R.id.display);
       Button add=(Button)findViewById(R.id.addnotes);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"OPENING NOTES..",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getApplicationContext(),display.class);

                startActivity(i);
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"processing..",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),notes.class);
                startActivity(intent);
            }
        });
    }
}
