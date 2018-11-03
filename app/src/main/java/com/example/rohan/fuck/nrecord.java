package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class nrecord extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;

    public void kick(View view) {
        Intent intent = new Intent(getApplicationContext(), AfLogin.class);
        startActivity(intent);
    }

    public void logo(View view) {
        ParseUser.logOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void insert(View view) {
        ParseObject object = new ParseObject("Admins");
        object.put("Admin", usernameEditText.getText().toString());
        object.put("password", passwordEditText.getText().toString());
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(com.parse.ParseException ex) {
                if (ex == null) {
                    Toast.makeText(nrecord.this,"Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AfLogin.class);
                    startActivity(intent);
                    Log.i("Parse Result", "Successful!");
                } else {
                    Log.i("Parse Result", "Failed" + ex.toString());
                }
            }
        });

        ParseUser user = new ParseUser();
        user.setUsername(usernameEditText.getText().toString());
        user.setPassword(passwordEditText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {

                    Log.i("Signup", "Successful");
                    Toast.makeText(nrecord.this,"Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AfLogin.class);
                    startActivity(intent);

                } else {

                    //Toast.makeText(nrecord.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nrecord);
        setTitle("New Record");
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
    }
}
