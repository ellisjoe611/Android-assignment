package com.example.ellis.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Prepare elements
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);     //call button element by id
        registerForContextMenu(button);     //start initializing button function
    }

    //This function will add several options on contextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.add(0,1,0,"Red");      //1: "Red"
        menu.add(0,2,0,"Green");    //2: "Green"
        menu.add(0,3,0,"Blue");     //3: "Blue"
    }

    //This function will accept options and change the text color on button
    //according to '.getItemId()' on 'menu'
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:     //change text color to red
                button.setTextColor(Color.RED);
                break;
            case 2:     //change text color to green
                button.setTextColor(Color.GREEN);
                break;
            case 3:     //change text color to blue
                button.setTextColor(Color.BLUE);
                break;
        }

        return true;    //meaning that option selection is successfully finished
    }
}
