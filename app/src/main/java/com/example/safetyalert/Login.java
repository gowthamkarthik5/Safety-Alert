package com.example.safetyalert;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button b4;
    EditText e7, e8;
    String s7, s8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b4 = (Button) findViewById(R.id.btn4);
        e7 = (EditText) findViewById(R.id.ed7);
        e8 = (EditText) findViewById(R.id.ed8);
        s7 = e7.getText().toString();
        s8 = e8.getText().toString();

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
