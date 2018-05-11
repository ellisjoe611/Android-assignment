package com.example.ellis.lab4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //calling 'MyDraw' class on this MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyDraw myDraw = new MyDraw(this);
        setContentView(myDraw);
    }

}
