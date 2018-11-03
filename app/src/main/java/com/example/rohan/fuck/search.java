package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    String one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search Event");
        final ArrayList<String> usernames = new ArrayList<String>();

        final ListView userListView = (ListView) findViewById(R.id.userListView);

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usernames);
        Intent intent = getIntent();
       one= intent.getStringExtra("event name");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Events");
        query.whereEqualTo("eventname",one);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null && objects != null) {

                    {


                        for (ParseObject object : objects) {
                            usernames.add(object.getString("date")+"          "+object.getString("eventname")+"            "+object.getString("venue"));
                        }
                    }

                    userListView.setAdapter(arrayAdapter);
                }

            }


        });




    }
}
