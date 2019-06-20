package com.example.lynn.fourth;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.lynn.fourth.MainActivity.*;
import static com.example.lynn.fourth.MainActivity.context;

public class MyView extends RelativeLayout {

    public MyView(Context context) {
        super(context);

        Point sizeOfScreen = Util.sizeOfScreen(context);

        width = sizeOfScreen.x;
        height = sizeOfScreen.y;

        drawables = new int[]{R.drawable.bear,
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

        threads = new HashMap<>();

        views = new ImageView[drawables.length];

        LayoutParams layoutParams = new LayoutParams(200,200);

        for (int counter=0;counter<4;counter++) {
            views[counter] = new ImageView(context);

            views[counter].setId(generateViewId());

            views[counter].setImageDrawable(getResources().getDrawable(drawables[counter]));

            views[counter].setOnTouchListener(listener);

            MyThread myThread = new MyThread(views[counter]);

            threads.put(views[counter],myThread);
        }

        views[0].setLayoutParams(layoutParams);

        addView(views[0]);

        for (int counter=1;counter<4;counter++) {
            layoutParams = new LayoutParams(200,200);

            layoutParams.addRule(RIGHT_OF,views[counter-1].getId());

            views[counter].setLayoutParams(layoutParams);

            addView(views[counter]);
        }



   //     AddImage addImage = new AddImage();









    }

}
