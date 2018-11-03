package com.example.rohan.fuck;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.util.List;
public class drecords extends AppCompatActivity {
    public void kick(View view) {
        Intent intent = new Intent(getApplicationContext(), AfLogin.class);
        startActivity(intent);
    }
    public void logo(View view) {
        ParseUser.logOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    Button lund;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drecords);
        lund = (Button) findViewById(R.id.lund);
        setTitle("Delete Records");
        editText1 = (EditText) findViewById(R.id.kane);
        lund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Admins");
                query.whereEqualTo("Admin", editText1.getText().toString());
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        for (ParseObject object : objects) {
                            try {
                                object.delete();
                                object.saveInBackground();
                                Toast.makeText(drecords.this,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),AfLogin.class);
                                startActivity(intent);
                            } catch (ParseException exe) {
                                exe.printStackTrace();
                                Toast.makeText(drecords.this,"Username does not exist",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
            }
        });
    }
}