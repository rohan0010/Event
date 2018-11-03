package com.example.rohan.fuck;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import java.text.ParseException;
import java.util.List;
public class admin extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    String one;
    public void username() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Admins");
        query.whereEqualTo("Admin", usernameEditText.getText().toString());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {

                if (e == null && objects != null) {
                    for (ParseObject object : objects) {


                        {
                            one =object.getString("Admin");
                        }
                    }
                }
            }
        });
    }
    public void aflogin(View view)
    {

        //signup();
        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {

            Toast.makeText(this, "A username and password are required.", Toast.LENGTH_SHORT).show();

        }
        else {
            username();
            if(usernameEditText.getText().toString().equals(one))
            ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {

                @Override
                public void done(ParseUser user, com.parse.ParseException e) {

                    if (user != null ) {
                       Intent intent=new Intent(getApplicationContext(),AfLogin.class);
                        intent.putExtra("username",usernameEditText.getText().toString());
                        startActivity(intent);

                        Log.i("Signup", "Login successful");

                    } else {

                        Toast.makeText(admin.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }


                }
            });

        }

        }
    public void go(View view)
    { Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }
    public void signup()
    {
        ParseUser user = new ParseUser();
        user.setUsername("Anubha");
        user.setPassword("12345");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {

                    Log.i("Signup", "Successful");

                } else {

                    Toast.makeText(admin.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setTitle("Admin Login");
        usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

    }
}

