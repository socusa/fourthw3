package com.example.lynn.fourth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static MyView myView;
    public static MyListener listener = new MyListener();
    public static int width;
    public static int height;
    public static Map<ImageView,MyThread> threads;
    public static ImageView imageView;
    public static Context context;
    public static int[] drawables;
    public static AddImage addImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        setContentView(myView = new MyView(this));
    }

    public void onDestroy() {
        super.onDestroy();

        if (threads != null) {
            for (ImageView view : threads.keySet())
                threads.get(view).stop();
        }
    }
}
