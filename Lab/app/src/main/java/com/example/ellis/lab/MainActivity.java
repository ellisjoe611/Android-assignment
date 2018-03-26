package com.example.ellis.lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //First, set all of imageViews and buttons...
    ImageView imageView, imageView2;
    Button button;
    int imageIndex = 0; //just in case of switching images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call all layouts from 'activity_main.xml' in order to convert each of them into objectives

        //Second, call all elements by using IDs defined on 'R' class
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(this);    //start action when clicking button
        //Implementing interface(func.) called 'setOnClickListener' will override 'onClick' func.
    }

    @Override
    public void onClick(View view) {
        /*
        * <imageIndex>
        *     0: first 'imageView' is currently visible.
        *     1: second 'imageView2' is currently visible.
        *
        * by switching 'imageIndex', it will turn each imageView visible or INvisible.
        * */
        if(imageIndex == 0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 1;
        }else if(imageIndex==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex = 0;
        }
    }
}
