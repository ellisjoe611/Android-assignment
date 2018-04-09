package com.example.ellis.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    //setting all elements
    TextView textView_url;
    Button button_go, button_back;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        //First, call all elements from 'activity_confirm.xml'
        textView_url = findViewById(R.id.textView_url);
        button_go = findViewById(R.id.button_go);
        button_back = findViewById(R.id.button_back);

        //Second, create the intent 'resultIntent' that will be used in this class...
        Intent resultIntent = getIntent();

        //when 'resultIntent' is successfully created,
        //get the string that were set on the intent as "url"
        if(resultIntent != null){
            url = resultIntent.getStringExtra("url");
            textView_url.setText(url);  //set the 'url' on textView on the top
        }

        //start to define actions of each button
        button_go.setOnClickListener(this);
        button_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //define actions when selecting either of two buttons...
        switch (v.getId()){
            case R.id.button_go:    //when selecting 'Go'
                //create intent that directly connects web page via browser application
                //when connecting to web browser, make sure to include "http://" or "https://"
                //at the first of Uri query...
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                startActivity(webIntent);
                break;

            case R.id.button_back:  //when selecting 'back'
                finish();   //finish 'resultIntent'
        }
    }
}
