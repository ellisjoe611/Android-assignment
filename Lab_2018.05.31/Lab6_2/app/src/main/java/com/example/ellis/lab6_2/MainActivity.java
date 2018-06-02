package com.example.ellis.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_name, editText_sn;
    Button button_load, button_save, button_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.editText_name);
        editText_sn = findViewById(R.id.editText_sn);
        button_load = findViewById(R.id.button_load);
        button_save = findViewById(R.id.button_save);
        button_reset = findViewById(R.id.button_reset);

        //load database
        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
                Toast.makeText(MainActivity.this, "Successfully loaded.", Toast.LENGTH_SHORT).show();
            }
        });

        //save database
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editText_name.getText().toString();
                String newSN = editText_sn.getText().toString();

                //call error message if either of all inputs is empty...
                if(newName.equalsIgnoreCase("") || newSN.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Input all info...", Toast.LENGTH_SHORT).show();
                }else{
                    //start saving input on database in this app.
                    sharedPreferences(newName, newSN);
                    Toast.makeText(MainActivity.this, "Successfully saved.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //clear all inputs
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_name.setText("");
                editText_sn.setText("");
                Toast.makeText(MainActivity.this, "Reset input...", Toast.LENGTH_SHORT).show();
            }
        });
        
    }

    //call shared references from database
    private void sharedPreferences(String newName, String newSN) {
        SharedPreferences sharedPreferences = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", newName);
        editor.putString("UserNum", newSN);
        editor.commit();

    }

    //load shared references from database
    private void applySharedPreference() {
        SharedPreferences sharedPreferences = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sharedPreferences != null && sharedPreferences.contains("Username")){
            String name = sharedPreferences.getString("Username", "No name");
            editText_name.setText(name);
        }

        if (sharedPreferences != null && sharedPreferences.contains("UserNum")){
            String SN=sharedPreferences.getString("UserNum", "No SN");
            editText_sn.setText(SN);
        }

    }
}
