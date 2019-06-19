package com.example.lynn.fourth;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.example.lynn.fourth.MainActivity.*;

public class MyListener implements View.OnTouchListener {
    private int offsetX;
    private int offsetY;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView source = (ImageView)view;

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)source.getLayoutParams();



        return (true);
    }

}
