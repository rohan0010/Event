package com.example.rohan.fuck;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class student extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    Intent intent;
    String one;
    public void username() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Students");
        query.whereEqualTo("Student", usernameEditText.getText().toString());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null && objects != null) {
                    for (ParseObject object : objects) {


                        {
                            one =object.getString("Student");
                        }
                    }
                }
            }
        });
    }
    public void login(View view) {

        //signup();
        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {

            Toast.makeText(this, "A username and password are required.", Toast.LENGTH_SHORT).show();

        } else {            username();
                           if(usernameEditText.getText().toString().equals(one))

                            ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {

                                @Override
                                public void done(ParseUser user, com.parse.ParseException e) {

                                    if (user != null) {
                                        intent = new Intent(getApplicationContext(), loda.class);
                                        intent.putExtra("username", usernameEditText.getText().toString());
                                        startActivity(intent);

                                        Log.i("Signup", "Login successful");

                                    } else {

                                        Toast.makeText(student.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                    }


                                }

                            });

                        }
                            }





    public void signUp(View view)
    {
        Intent ent = new Intent(getApplicationContext(),studentsignup.class);
        startActivity(ent);
    }
    public void go(View view)
    {
        Intent tits = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(tits);
    }
    public void tamara(View view)
    {
        Intent gandu = new Intent(getApplicationContext(),registerevent.class);
        startActivity(gandu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        setTitle("Student");
        usernameEditText = (EditText)findViewById(R.id.editText);
        passwordEditText = (EditText)findViewById(R.id.editText2);
    }
}
