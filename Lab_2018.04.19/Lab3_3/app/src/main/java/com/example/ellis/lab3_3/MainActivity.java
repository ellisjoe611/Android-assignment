package com.example.ellis.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Prepare elements for mainActivity
    public FirstFragment firstFrag;
    public SecondFragment secondFrag;
    Button button_tab1, button_tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First, call elements such as buttons and Fragments
        button_tab1 = findViewById(R.id.button_tab1);
        button_tab2 = findViewById(R.id.button_tab2);
        firstFrag = new FirstFragment();
        secondFrag = new SecondFragment();

        //Second, call function for responding to button clicks
        button_tab1.setOnClickListener(this);
        button_tab2.setOnClickListener(this);
    }

    //This method will accept one of the buttons' IDs and show Fragment on FrameLayout
    //The FrameLayout is already initialized on activity_main.xml
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_tab1:  //selecting 'tab1' for displaying firstFrag
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_for_fragment, firstFrag).commit();
                break;
            case R.id.button_tab2:  //selecting 'tab2' for displaying secondFrag
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_for_fragment, secondFrag).commit();
                break;
        }
    }
}
