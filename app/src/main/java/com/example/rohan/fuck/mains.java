package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class mains extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.home:
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.events:
                Intent choot=new Intent(getApplicationContext(),mains.class);
                startActivity(choot);
                return true;
            case R.id.aboutus:
                Intent tent=new Intent(getApplicationContext(),about.class);
                startActivity(tent);
                return true;
            case R.id.contact:
                Intent tmara = new Intent(getApplicationContext(),Contact.class);
                startActivity(tmara);
                return true;
            case R.id.admins:
                Intent bent=new Intent(getApplicationContext(),admin.class);
                startActivity(bent);
                return true;
            case R.id.student:
                Intent ent=new Intent(getApplicationContext(),student.class);
                startActivity(ent);
                return true;
            default:
                return false;

        }
    }

    String one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        setTitle("Events");
        final ArrayList<String> usernames = new ArrayList<String>();


        final ListView userListView = (ListView) findViewById(R.id.userListView);

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usernames);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Events");

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
