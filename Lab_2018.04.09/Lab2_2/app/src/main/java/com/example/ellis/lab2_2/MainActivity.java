package com.example.ellis.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //setting elements...
    EditText editText_url;
    Button button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First, call all elements from 'activity_main.xml'
        editText_url = findViewById(R.id.editText_url);
        button_next = findViewById(R.id.button_next);

        //Then, set the action when 'next' button is clicked...
        button_next.setOnClickListener(this);
    }

    //when clicked 'next' button...
    @Override
    public void onClick(View v) {
        //First, Accept the string from 'editText_url'
        String urlInput = editText_url.getText().toString().trim();

        //Then, if the string is empty, display Toast message.
        if(urlInput.equalsIgnoreCase("")){
            Toast.makeText(this, "Please enter the address except \'http://\'...", Toast.LENGTH_SHORT).show();
        } else {
            //If entered, create the intent heading to 'ConfirmActivity' class
            Intent intent = new Intent(getApplicationContext(), ConfirmActivity.class);

            //add the string 'urlInput' in this intent as "url"...
            intent.putExtra("url", urlInput);

            startActivity(intent);  //finally, move on to 'ConfirmActivity' by starting the intent
        }

    }
}
