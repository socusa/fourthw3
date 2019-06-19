package com.example.lynn.fourth;

import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.example.lynn.fourth.MainActivity.*;

public class MyThread implements Runnable {
    private ImageView imageView;
    private double delay;
    private double distance;
    private boolean keepGoing;

    public MyThread(ImageView imageView) {
        this.imageView = imageView;

        delay = 1;

        distance = 1;
    }

    public void start() {
        delay -= 0.1;

        distance += 0.1;

        Thread thread = new Thread(this);

        keepGoing = true;

        thread.start();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((int)(seconds*1000));
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    public void stop() {
        keepGoing = false;
    }

    @Override
    public void run() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();

        while (layoutParams.topMargin < height && keepGoing) {
            layoutParams.topMargin += distance;

            final RelativeLayout.LayoutParams temp = layoutParams;

            imageView.post(new Runnable() {

                @Override
                public void run() {
                    imageView.setLayoutParams(temp);
                }

            });

            pause(delay);

            layoutParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
        }
    }

}
