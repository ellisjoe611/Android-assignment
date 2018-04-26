package com.example.ellis.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//this method will create new Activity that shows all inputs from MainActivity
public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    //Prepare all elements
    TextView textView_name, textView_gender, textView_sub;
    Button button_goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        //First, call all elements needed
        textView_name = findViewById(R.id.textView_name);
        textView_gender = findViewById(R.id.textView_gender);
        textView_sub = findViewById(R.id.textView_sub);
        button_goback = findViewById(R.id.button_goback);

        //Second, call the previous intent sent from MainActivity
        Intent intent = getIntent();

        //Third, get all stored data on intent & display them on textViews
        textView_name.setText(intent.getStringExtra("name"));
        textView_gender.setText(intent.getStringExtra("gender"));
        textView_sub.setText(intent.getStringExtra("sub"));

        //set button 'goBack'
        button_goback.setOnClickListener(this);
    }

    //This method will terminate current activity
    //by finishing current activity with finish()
    @Override
    public void onClick(View v) {
        finish();
    }
}
