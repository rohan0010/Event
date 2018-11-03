package com.example.rohan.fuck;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class Contact extends AppCompatActivity {
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

    public void gog(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    Button submit;
    EditText one;
    EditText two;
    EditText three;
    String to,message,subject,mail,ll,pp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setTitle("Contact Us");
        submit =(Button) findViewById(R.id.submit);
        one=(EditText)findViewById(R.id.to);
        two=(EditText)findViewById(R.id.subject);
        three=(EditText)findViewById(R.id.message);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject object = new ParseObject("Contactus");
                object.put("fullname", two.getText().toString());
                object.put("emailhere", one.getText().toString());
                object.put("message",three.getText().toString());
                object.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException ex) {
                        if (ex == null) {
                            Log.i("Parse Result", "Successful!");;
                        } else {
                            Log.i("Parse Result", "Failed" + ex.toString());
                        }
                    }
                });
                ll="shubhamrustagi88@gmail.com";
                pp="deljainanu@gmail.com";
                //Intent email = new Intent(Intent.ACTION_SENDTO);
                Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","tush.cd@gmail.com",null));
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { ll,pp});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
               // email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Select Email app"));

            }
        });
    }}
