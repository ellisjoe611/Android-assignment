package com.example.ellis.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    //set the element from 'activity_result.xml'
    Button button_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //First, get the button element
        button_exit = findViewById(R.id.button_exit);

        //Second, create the intent that receives data from 'MainActivity.java'
        Intent resultIntent = getIntent();

        //If resultIntent != null, it means that we're ready to go!
        if(resultIntent != null) {
            //get 'name' and 'age' from intent and store them into each String attribute
            String name = resultIntent.getStringExtra("name");
            String age = resultIntent.getStringExtra("age");

            //combine 'name' and 'age' and display them in Toast message
            Toast.makeText(getApplicationContext(), "Student info : " + name + ", " + age, Toast.LENGTH_LONG).show();
        }

        //Finally, set the action of button in order to exit the activity of THIS class...
        button_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();   //finish intent, returning to previous activity
    }
}
