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
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class nevent extends AppCompatActivity {

    Button mbutton;

    public void kick(View view)
    {
        Intent intent=new Intent(getApplicationContext(),AfLogin.class);
        startActivity(intent);
    }
    public void logo(View view)
    {
        ParseUser.logOut();
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    /*public void kiss(View view)
    {   one=eventEdittext.getText().toString();
        two=dateEdittext.getText().toString();
        three=venueEdittext.getText().toString();
        four=feesEdittext.getText().toString();
        five=aboutEdittext.getText().toString();
        ParseObject object= new ParseObject("events");
        object.put("event name",one);
       object.put("date",two);
        object.put("venue",three);
        object.put("fees",four);
        object.put("about",five);

        object.saveInBackground(new SaveCallback () {
            @Override
            public void done(ParseException ex) {
                if (ex == null) {
                    Log.i("Parse Result", "Successful!");
                } else {
                    Log.i("Parse Result", "Failed" + ex.toString());
                }
            }
        });

    }*/
    EditText eventEdittext;
    EditText dateEdittext;
    EditText venueEdittext;
    EditText feesEdittext;
    EditText aboutEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevent);
        setTitle("New Event");

        eventEdittext = (EditText) findViewById(R.id.eventEdittext);
        venueEdittext = (EditText) findViewById(R.id.venueEdittext);
        feesEdittext = (EditText) findViewById(R.id.feesEdittext);
        dateEdittext=(EditText)findViewById(R.id.dateEdittext);
        aboutEdittext = (EditText) findViewById(R.id.aboutEdittext);
        mbutton = (Button) findViewById(R.id.boob);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject object = new ParseObject("Events");
                object.put("eventname", eventEdittext.getText().toString());
                object.put("date", dateEdittext.getText().toString());
                object.put("venue", venueEdittext.getText().toString());
                object.put("fees", feesEdittext.getText().toString());
                object.put("about", aboutEdittext.getText().toString());

                object.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException ex) {
                        if (ex == null) {
                            Log.i("Parse Result", "Successful!");
                            Toast.makeText(nevent.this,"Inserted Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),AfLogin.class);
                            startActivity(intent);
                        } else {
                            Log.i("Parse Result", "Failed" + ex.toString());
                        }
                    }
                });
            }
        });
    }}

