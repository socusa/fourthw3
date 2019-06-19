package com.example.lynn.fourth;

import android.content.Context;
import android.graphics.Point;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;

import java.util.HashMap;

import static com.example.lynn.fourth.MainActivity.*;

public class MyView extends RelativeLayout {

    public MyView(Context context) {
        super(context);

        Point sizeOfScreen = Util.sizeOfScreen(context);

        width = sizeOfScreen.x;
        height = sizeOfScreen.y;

        int[] drawables = {R.drawable.bear,
                           R.drawable.bird,
                           R.drawable.cat,
                           R.drawable.cow,
                           R.drawable.eagle,
                           R.drawable.elephant,
                           R.drawable.lioness,
                           R.drawable.llama,
                           R.drawable.panda,
                           R.drawable.pig,
                           R.drawable.rabbit,
                           R.drawable.rhino,
                           R.drawable.rooster,
                           R.drawable.sheep,
                           R.drawable.snake,
                           R.drawable.tiger,
                           R.drawable.turtle,
                           R.drawable.zebra};

        imageView = new ImageView(context);

        imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.bear));

        addView(imageView);

        imageView.setOnTouchListener(listener);

        MyThread myThread = new MyThread(imageView);

        threads = new HashMap<>();

        threads.put(imageView,myThread);



    }

}