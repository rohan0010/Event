package com.example.rohan.fuck;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;

public class AfLogin extends AppCompatActivity {

    String currentUserString;
    public void record(View view)
    {
        Intent intent=new Intent(getApplicationContext(),nrecord.class);
        startActivity(intent);
    }
    public void event(View view)
    {
        Intent intent=new Intent(getApplicationContext(),nevent.class);
        startActivity(intent);
    }
    public void kevent(View view)
    {
        Intent intent=new Intent(getApplicationContext(),uevent.class);
        startActivity(intent);
    }
    public void pasword(View view)
    {
        Intent intent=new Intent(getApplicationContext(),cpassword.class);
        startActivity(intent);
    }
    public void devent(View view)
    {
        Intent intent=new Intent(getApplicationContext(),devents.class);
        startActivity(intent);
    }
    public void drecord(View view)
    {
        Intent intent=new Intent(getApplicationContext(),drecords.class);
        startActivity(intent);
    }
    public void logo(View view)
    {
        ParseUser.logOut();
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_af_login);
        textView=(TextView)findViewById(R.id.textView6);
        setTitle("Admin Accesories");
        ParseUser currentUser = ParseUser.getCurrentUser();
        currentUserString = String.valueOf(currentUser.getUsername());
        if (currentUser != null) {
            textView.setText("WELCOME   "+currentUserString);
        } else {
            // show the signup or login screen
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ParseUser.logOut();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }}
