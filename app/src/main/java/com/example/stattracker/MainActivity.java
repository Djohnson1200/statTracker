package com.example.stattracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();
        values.put("FName", "Derek");
        values.put("LName", "Johnson");
        values.put("NumberOfTeams", 10);

        //Find elements
        button = (Button) findViewById(R.id.buttonOne);
        DBHelper database = new DBHelper(MainActivity.this);
        SQLiteDatabase db = database.getWritableDatabase();;


        //Initialize Listeners
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}