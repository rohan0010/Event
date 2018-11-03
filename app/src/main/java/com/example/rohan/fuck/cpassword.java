package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class cpassword extends AppCompatActivity {
    public void kick(View view) {
        Intent intent = new Intent(getApplicationContext(), AfLogin.class);
        startActivity(intent);
    }

    public void logo(View view) {
        ParseUser.logOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    Button dutto;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpassword);
        setTitle("change password");
        dutto = (Button) findViewById(R.id.riverdale);
        editText1 = (EditText) findViewById(R.id.username);
        editText2 = (EditText) findViewById(R.id.password);

        dutto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*ParseQuery<ParseUser> query = ParseUser.getQuery();
                query.whereMatches("username", editText1.getText().toString());
                query.findInBackground(new FindCallback<ParseUser>() {
                    public void done(List<ParseUser> objects, ParseException e) {
                        if (e == null && objects != null) {
                            for (ParseUser object : objects) {
                                object.put("password", editText2.getText().toString());
                                object.saveInBackground();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Query Not Successful", Toast.LENGTH_LONG).show();
                        }
                    }


            });
        }
    });
}}*/
                ParseUser parseUser = ParseUser.getCurrentUser();
                parseUser.setPassword(editText2.getText().toString());
                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (null == e) {
                            Log.i("password change","successful");
                            Toast.makeText(cpassword.this,"Password Changed Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),AfLogin.class);
                            startActivity(intent);
                        } else {
                            // report about error
                        }
                    }
                });
            }
        });
    }
}