package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class loda extends AppCompatActivity {
      public void logout(View view)
      {
          ParseUser.logOut();
          Intent intent = new Intent(getApplicationContext(),MainActivity.class);
          startActivity(intent);
      }
      public void jojo(View view)
      {
          Intent intent= new Intent(getApplicationContext(),showevent.class);
          startActivity(intent);
      }
      public void search(View view)
      {
        Intent intent = new Intent(getApplicationContext(),search.class);
        intent.putExtra("event name",event.getText().toString());
        startActivity(intent);
      }
      TextView lodaTextview;
      EditText event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loda);
        setTitle("Student Accesories");
        lodaTextview =(TextView)findViewById(R.id.lodaTextview);
        event=(EditText)findViewById(R.id.event);
        Intent intent = getIntent();
        lodaTextview.setText("WELCOME   "+intent.getStringExtra("username"));
        ParseObject object = new ParseObject("Students");
        object.put("Studentname", intent.getStringExtra("username"));
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