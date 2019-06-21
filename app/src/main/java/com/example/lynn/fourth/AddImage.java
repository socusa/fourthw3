package com.example.lynn.fourth;

import android.view.View;
import android.widget.ImageView;
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
        for (int counter=0;counter<10;counter++) {
            final int temp = counter;

            myView.post(new Runnable() {

                @Override
                public void run() {
                    views[temp].setVisibility(View.VISIBLE);
                }

            });

            pause(5);
        }



    }

}
