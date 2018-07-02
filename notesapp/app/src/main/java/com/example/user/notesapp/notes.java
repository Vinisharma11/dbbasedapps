package com.example.user.notesapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

       final EditText notes = (EditText) findViewById(R.id.noteText);
        Button add = (Button) findViewById(R.id.add);
        Button reset = (Button) findViewById(R.id.reset);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Note = notes.getText().toString();

                NoteAdd(Note);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.setText("");
            }
        });
    }

    void NoteAdd(String notes) {

        try {
            SQLiteDatabase db = this.openOrCreateDatabase("notesDB", MODE_PRIVATE, null);
            db.execSQL("create table if not exists list (notetext VARCHAR)");


            db.execSQL("insert into list values('" + notes + "')");
            Log.i("notes", "Success");
            Toast.makeText(getApplicationContext(), " ADDED TO NOTES..", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}