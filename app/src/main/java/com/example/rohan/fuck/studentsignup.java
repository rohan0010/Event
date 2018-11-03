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
public class studentsignup extends AppCompatActivity {
    EditText usernameEdittext;
    EditText passwordEdittext;

    public void signUp(View view) {
        ParseObject object = new ParseObject("Students");
        object.put("Student", usernameEdittext.getText().toString());
        object.put("password", passwordEdittext.getText().toString());
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException ex) {
                if (ex == null) {
                    Log.i("Parse Result", "Successful!");

                } else {
                    Log.i("Parse Result", "Failed" + ex.toString());
                }
            }
        });

        ParseUser student = new ParseUser();
        student.setUsername(usernameEdittext.getText().toString());
        student.setPassword(passwordEdittext.getText().toString());

        student.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    Toast.makeText(studentsignup.this, "signup successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), student.class);
                    startActivity(intent);

                    Log.i("Signup", "Successful");

                } else {

                    Toast.makeText(studentsignup.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void go(View view) {
        Intent intent = new Intent(getApplicationContext(), student.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentsignup);
        setTitle("Student sign up");
        usernameEdittext = (EditText) findViewById(R.id.usernameEditText);
        passwordEdittext = (EditText) findViewById(R.id.passwordEditText);

    }
}