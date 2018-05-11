package com.example.ellis.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    //initially define all necessary elements for drawing lines
    private Paint paint;
    private Path path;
    private float mx, my;   //save the recently marked coordinate (x,y)

    //initialize class 'MyDraw' in two cases
    //each class initialization contains method 'init()' (refer to 'init()' below...)
    public MyDraw(Context context){
        super(context);
        init();
    }
    public MyDraw(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    //initialize 'paint' and 'path' before drawing lines
    public void init(){
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    //define actions when user touches the screen
    //call current coordinate -> define actions on 3 cases (touch down, drag, release touch)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //First call the current coordinate where user is pointing at
        float x = event.getX();
        float y = event.getY();

        //Second, define actions on 3 cases below
        switch (event.getAction()){
            //when user start touching the screen...
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);  //move to current coordinate to start drawing
                mx = x;     //save the current coordinate on 'mx' and 'my'
                my = y;
                invalidate();

            //when user starts dragging...
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);    //update the coordinate (mx, my). (Refer to definition below)
                invalidate();
            case MotionEvent.ACTION_UP:
                path.lineTo(mx, my);    //mark the line up to recent (mx, my) to stop marking
                invalidate();
        }

        return true;
    }

    //define how marking coordinate (mx, my) can be updated & marked concurrently
    private void moveTouch(float x, float y) {
        //First, we need to get the DISTANCE between currently recorded coordinate(x,y)
        //...and recently updated coordinate (mx, my)
        //Math.abs is used when getting
        float dx = Math.abs(x - mx);    //dx: distance between 'x' and 'mx'
        float dy = Math.abs(y - my);    //dy: distance between 'y' and 'my'

        //Then, if each distance is less than 5 meaning that the line is NOT straight forward,
        //call Quadratic function to make the curved path smooth.
        //quadTo(): draws a curved line, based on some Quadratic function
        if (dx >= 5 || dy >= 5) {
            path.quadTo(mx, my, (x + mx) / 2, (y + my) / 2);
            mx = x;
            my = y;
        }

    }

    //mark the 'paint' concurrently on 'path' on canvas
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }
}
