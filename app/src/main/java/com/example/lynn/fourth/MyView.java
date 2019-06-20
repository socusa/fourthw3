package com.example.lynn.fourth;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

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

        addImage = new AddImage();

        message = new TextView(context);

        message.setId(generateViewId());

        message.setText("Hello");

        LayoutParams layoutParams = new LayoutParams(500,200);

        layoutParams.topMargin = 500;

        message.setLayoutParams(layoutParams);

        addView(message);

        layoutParams = new LayoutParams(200,200);

        layoutParams.addRule(ABOVE,message.getId());

        RelativeLayout layout = new RelativeLayout(context);

        layout.setBackgroundColor(0xFF000000);

        addView(layout);





    }

    public void add(View view) {

    }

}
