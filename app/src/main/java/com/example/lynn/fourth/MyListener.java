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

        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            threads.get(source).stop();

            offsetX = (int)(motionEvent.getRawX() - layoutParams.leftMargin);
            offsetY = (int)(motionEvent.getRawY() - layoutParams.topMargin);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            layoutParams.leftMargin = (int)(motionEvent.getRawX() - offsetX);
            layoutParams.topMargin = (int)(motionEvent.getRawY() - offsetY);

            view.setLayoutParams(layoutParams);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            threads.get(source).start();
        }


        return (true);
    }

}
