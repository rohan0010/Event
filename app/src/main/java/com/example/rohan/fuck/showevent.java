package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class showevent extends AppCompatActivity {
     TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showevent);
        setTitle("Show Event");
        final ArrayList<String> usernames = new ArrayList<String>();
        final ArrayList<String> event=new ArrayList<String>();
        final ArrayList<String>venue=new ArrayList<String>();
        final ListView listview2=(ListView)findViewById(R.id.listview2);
        final ListView listView3=(ListView)findViewById(R.id.listview3);
        final ListView userListView = (ListView) findViewById(R.id.userListView);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usernames);
        final ArrayAdapter Adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,venue);
        final ArrayAdapter array= new ArrayAdapter(this,android.R.layout.simple_list_item_2,event);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Events");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null && objects != null) {

                    {


                        for (ParseObject object : objects) {
                            usernames.add(object.getString("date"));
                            venue.add(object.getString("venue"));
                            event.add(object.getString("eventname"));
                        }
                    }
                    userListView.setAdapter(arrayAdapter);
                    listview2.setAdapter(Adapter);
                    listView3.setAdapter(array);
                }

            }


        });




    }
}


