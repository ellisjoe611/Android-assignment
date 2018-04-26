package com.example.ellis.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Prepare all elements
    EditText editText_name;
    RadioGroup radioGroup_gender;
    RadioButton radioButton_man, radioButton_woman;
    CheckBox checkBox_sms, checkBox_email;
    Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First, call all elements
        editText_name = findViewById(R.id.editText_name);
        radioGroup_gender = findViewById(R.id.radioGroup_gender);
        radioButton_man = findViewById(R.id.radioButton_man);
        radioButton_woman = findViewById(R.id.radioButton_woman);
        checkBox_sms = findViewById(R.id.checkBox_sms);
        checkBox_email = findViewById(R.id.checkBox_email);
        button_register = findViewById(R.id.button_register);

        //Then, set the button click listener
        button_register.setOnClickListener(this);
    }


    //In this method, we will first make sure that the name & radioButton input is inserted
    //before sending them to next activity called 'ConfirmActivity'
    //Use intent for sending all inputs to next activity
    @Override
    public void onClick(View v) {
        //First, check whether the name is inserted or NOT
        if (editText_name.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "Error: Enter your name...", Toast.LENGTH_SHORT).show();
        }
        //Second, check if none of radioButtons is selected
        else if (!radioButton_man.isChecked() && !radioButton_woman.isChecked()){
            Toast.makeText(this, "Error: Select your gender...", Toast.LENGTH_SHORT).show();
        }
        //if user name is inserted & radioButton is checked
        //we'll start sending all inputs to activity called 'ConfirmActivity'
        else {

            //First, create an intent heading to 'ConfirmActivity.class'
            Intent intent = new Intent(this, ConfirmActivity.class);

            //Then, add name on intent
            intent.putExtra("name", editText_name.getText().toString());

            //add gender information based on selected radioButton
            if(radioGroup_gender.getCheckedRadioButtonId() == radioButton_man.getId()){
                intent.putExtra("gender", "남");
            }if(radioGroup_gender.getCheckedRadioButtonId() == radioButton_woman.getId()){
                intent.putExtra("gender", "여");
            }

            //add subscription information based on checkBoxes
            String subscribeOption = "";
            if(checkBox_sms.isChecked()){
                subscribeOption += "SMS ";
            }
            if(checkBox_email.isChecked()){
                subscribeOption += "E-mail ";
            }
            //if none of checkBoxes is selected, set subscription info as "No subscription"
            if(!checkBox_sms.isChecked() && !checkBox_email.isChecked()){
                subscribeOption += "No subscription";
            }
            intent.putExtra("sub", subscribeOption);

            //Finally, start sending intent
            startActivity(intent);
        }
    }


}
