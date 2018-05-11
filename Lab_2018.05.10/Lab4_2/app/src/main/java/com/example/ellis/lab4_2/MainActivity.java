package com.example.ellis.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Define all necessary elements
    LinearLayout baseArea, slidingArea;
    Button button;

    //set the mode for viewing
    //0: hide slideArea , 1: slide-show slideArea
    int viewMode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all elements
        baseArea = findViewById(R.id.baseArea);
        slidingArea = findViewById(R.id.slidingArea);
        button = findViewById(R.id.button);

        //then, start calling actions on button click
        button.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        //First, call all AnimationUtils that are linked to R/anim/...
        //translate2 : slide-open 'slidingArea' from right edge to left
        //translate  : slide-close 'slidingArea' back to right edge
        Animation open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate2);
        Animation close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);

        //call actions of each 'viewMode'
        switch (viewMode){
            //when viewMode = 0 meaning 'slidingArea' hasn't shown yet..
            case 0:
                button.setText("Close Page");   //First, change the text on 'button'
                viewMode += 1;                  //Second, update variable 'ViewMode'
                slidingArea.setVisibility(View.VISIBLE);    //set 'slidingArea' visible before anim
                slidingArea.startAnimation(open);   //Finally, start anim called 'open'
                break;

            //when viewMode = 1 meaning 'slidingArea' is already displayed..
            case 1:
                button.setText("Open Page");    //First, change the text on 'button'
                viewMode -= 1;                  //Second, update variable 'viewMode'
                slidingArea.startAnimation(close);  //start anim called 'close'
                slidingArea.setVisibility(View.GONE);   //after anim, set 'slidingArea' invisible
                break;
        }
    }
}
