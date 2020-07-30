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

public class SignIn extends AppCompatActivity {

    Button b3;
    EditText e1, e2, e3, e4;

    String s1="", s2="", s3="", s4="", s5="", s6="", a="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        e1 = (EditText) findViewById(R.id.ed1);
        e2 = (EditText) findViewById(R.id.ed2);
        e3 = (EditText) findViewById(R.id.ed3);
        e4 = (EditText) findViewById(R.id.ed4);
        b3 = (Button) findViewById(R.id.btn3);

        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInDB();
            }
        });
    }

    private void saveInDB() {
        SQLiteDatabase db;
        db=openOrCreateDatabase("NumDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS details(name VARCHAR,number VARCHAR);");
        Cursor c=db.rawQuery("SELECT * FROM details", null);
        db.execSQL("INSERT INTO details VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"');");
        if(c.getCount()==1)
        {
            //db.execSQL("INSERT INTO details VALUES('"+s1+"','"+s4+"');");
            Toast.makeText(getApplicationContext(), "Successfully Saved",Toast.LENGTH_SHORT).show();
        }
        else {

            //db.execSQL("INSERT INTO details VALUES('"+s1+"','"+s4+"');");
            Toast.makeText(getApplicationContext(), "Maximun Numbers limited reached. Previous numbers are replaced.",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
