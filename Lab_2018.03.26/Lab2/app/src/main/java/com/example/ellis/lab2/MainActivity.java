package com.example.ellis.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_clear, button_print;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First, get all elements defined on 'activity_main.xml'
        button_clear = (Button)findViewById(R.id.button_clear);
        button_print = (Button)findViewById(R.id.button_print);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        //second, set the next action when clicking either 'clear' or 'print'
        button_clear.setOnClickListener(this);
        button_print.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_clear:
                //clear both 'editText' & 'textView' if they are not empty("")
                //by implementing .setText("")

                if(!editText.getText().toString().trim().equalsIgnoreCase(""))
                    editText.setText("");
                if(!textView.getText().toString().trim().equalsIgnoreCase(""))
                    textView.setText("");
                break;

            case R.id.button_print:
                //get String 'message' from 'editText' area
                // then print it out on 'textView'

                String message = editText.getText().toString().trim();
                textView.setText(message);
                break;
        }
    }
}
