package com.example.lynn.fourth;

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
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200,200);

        layoutParams.leftMargin = 50;
        layoutParams.topMargin = 200;

        for (int counter=0;counter<drawables.length;counter++) {
            final int temp = counter;

            myView.post(new Runnable() {

                @Override
                public void run() {
                    ImageView view = new ImageView(context);

                    view.setLayoutParams(layoutParams);

                    view.setOnTouchListener(listener);

                    MyThread myThread = new MyThread(view);

                    threads.put(view,myThread);

                    message.setText(drawables[temp]);

                    myView.add(view);

                    myView.invalidate();


                }

            });

            pause(5);
        }

    }

}
