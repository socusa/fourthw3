package com.example.lynn.fourth;

import android.widget.RelativeLayout;

import static com.example.lynn.fourth.MainActivity.*;

public class AddImage implements Runnable {
    private Thread thread;

    public AddImage() {
        thread = new Thread(this);

        thread.start();
    }

    public void pause(double seconds) {
        try {
            Thread.sleep((int)(seconds*1000));
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }


    @Override
    public void run() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200,200);


    }

}
