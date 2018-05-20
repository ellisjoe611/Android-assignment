package com.example.ellis.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //initialize all necessary elements...
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call elements
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        //when clicked button...
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //create dog thread on first imageView1
                DogThread thread1 = new DogThread(0);
                thread1.start();
                //create dog thread on second imageView2
                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });
    }

    public class DogThread extends Thread {
        int dogIndex;
        int stateIndex;
        ArrayList<Integer> images = new ArrayList<Integer>();

        //initialize DogThread
        public DogThread(int index){
            dogIndex = index;

            //add images on ArrayList<Integer>
            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_studying);
        }

        public void run(){
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;
                handler.post(new Runnable(){
                    public void run() {
                        editText.append(msg + "\n");
                        if (dogIndex == 0) {
                            imageView1.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }});
                try {
                    int sleepTime = getRandomTime(500, 3000);Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stateIndex++;
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }}
        }
    }

    //get random time
    private int getRandomTime(int min, int max) {
        return min+(int)(Math.random() * (max-min));
    }
}
