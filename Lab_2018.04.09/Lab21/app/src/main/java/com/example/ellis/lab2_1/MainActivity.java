package com.example.ellis.lab2_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //set elements of editText and button
    EditText editText_name, editText_age;
    Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First, get the attribute from 'activity_main.xml'
        editText_name = findViewById(R.id.editText_name);
        editText_age = findViewById(R.id.editText_age);
        button_add = findViewById(R.id.button_add);

        //Then, set the action of 'add' button
        button_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //store 2 strings from each 'editText'
        String newName = editText_name.getText().toString().trim();
        String newAge = editText_age.getText().toString().trim();

        //Then create the intent that destines to 'ResultActivity'
        Intent intent = new Intent (getApplicationContext(), ResultActivity.class);

        //and include two string into the intent
        intent.putExtra("name", newName);
        intent.putExtra("age", newAge);

        //Finally, start the intent to execute 'ResultActivity'
        startActivity(intent);
    }
}
