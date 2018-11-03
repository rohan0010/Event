package com.example.rohan.fuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class about extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About us");
    }
}
