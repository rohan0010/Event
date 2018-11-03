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
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.util.List;

public class uevent extends AppCompatActivity {
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
    Button button;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    String one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uevent);
        setTitle("Update Event");
        button=(Button)findViewById(R.id.boob);
        editText1=(EditText)findViewById(R.id.nameEdittext) ;
        editText2=(EditText)findViewById(R.id.datEdittext);
        editText3=(EditText)findViewById(R.id.placeEditText);
        editText4=(EditText)findViewById(R.id.peseEdittext);
        editText5=(EditText)findViewById(R.id.boutEdittext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Events");
                query.whereEqualTo("eventname", editText1.getText().toString());
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {

                        if (e == null && objects != null) {

                            for (ParseObject object : objects) {
                                if (editText1.getText().toString().equals(object.getString("eventname"))) {
                                    one=object.getString("eventname");
                                    object.put("date", editText2.getText().toString());
                                    object.put("venue", editText3.getText().toString());
                                    object.put("fees", editText4.getText().toString());
                                    object.put("about", editText5.getText().toString());
                                    object.saveInBackground();
                                    Toast.makeText(uevent.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), AfLogin.class);
                                    startActivity(intent);

                                }
                                }
                        }

                    }

                });

            }

        });
    }}

