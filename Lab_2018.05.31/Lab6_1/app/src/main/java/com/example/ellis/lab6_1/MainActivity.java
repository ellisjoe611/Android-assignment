package com.example.ellis.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText txtData;
    Button button, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = findViewById(R.id.txtData);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        //get SD external resources
        File sdCard = Environment.getExternalStorageDirectory();
        final File directory = new File(sdCard.getAbsolutePath() + "/Exercise6");
        directory.mkdirs();


        //write SD file
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File file = new File(directory, "mysdfile.txt");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);

                    OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream);
                    osw.write(txtData.getText().toString());
                    osw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Done writing SD \'mysdfile.txt\'", Toast.LENGTH_SHORT).show();
            }
        });

        //clear screen
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText("");
            }
        });

        //read SD file
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File file = new File(directory, "mysdfile.txt");
                    FileInputStream fileInputStream = new FileInputStream(file);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String str = "";
                    StringBuffer buffer = new StringBuffer();

                    while((str = reader.readLine()) != null){
                        buffer.append(str + "\n");
                    }
                    fileInputStream.close();
                    txtData.setText(buffer.toString());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Done reading SD \'mysdfile.txt\'", Toast.LENGTH_SHORT).show();
            }
        });

        //finish app
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Done reading SD ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
