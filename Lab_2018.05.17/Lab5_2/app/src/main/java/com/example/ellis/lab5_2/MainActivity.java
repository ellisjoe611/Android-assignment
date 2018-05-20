package com.example.ellis.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //initialize all necessary elements
    Button button;
    EditText editText;
    TextView textView1, textView2;
    int number, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call the elements
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        //when button clicked...
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FactorialTask().execute();  //automatically calls override methods below...
            }
        });
    }

    private class FactorialTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute() {
            //initialize textViews as empty
            textView1.setText("");
            textView2.setText("");

            //get the input number and initialize result as 1
            number = Integer.parseInt(editText.getText().toString());
            result = 1;
        }

        @Override
        protected Void doInBackground(Void... params) {
            while(number >= 1){
                try{
                    Thread.sleep(500);  //refresh the thread every 500 millis
                    publishProgress(number);    //publish result value on 'onPressUpdate'

                    //finally, calculate the current result and update current number
                    result *= number;
                    number -=1;
                } catch (InterruptedException e) { }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //append new values (number) next to previously saved 'textView1'
            textView1.append(" " + Integer.toString(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            textView2.append("=" + result); //show the result on 'textView2'
        }
    }
}
