package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class registerevent extends AppCompatActivity {
    public void go(View view)
    {
        Intent intent= new Intent(getApplicationContext(),student.class);
        startActivity(intent);
    }
     Button mbutton;
    EditText usernameEditText;
    EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerevent);
        setTitle("Register Event");
        usernameEditText=(EditText)findViewById(R.id.usernameEditText);
        passwordEditText =(EditText)findViewById(R.id.editText4);
        mbutton = (Button) findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject object = new ParseObject("Participants");
                object.put("Participantname", usernameEditText.getText().toString());
                object.put("eventname", passwordEditText.getText().toString());
                object.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException ex) {
                        if (ex == null) {
                            Log.i("Parse Result", "Successful!");
                            Intent intent = new Intent(getApplicationContext(),student.class);
                            startActivity(intent);
                            Toast.makeText(registerevent.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.i("Parse Result", "Failed" + ex.toString());
                        }
                    }
                });
            }
        });
    }}


