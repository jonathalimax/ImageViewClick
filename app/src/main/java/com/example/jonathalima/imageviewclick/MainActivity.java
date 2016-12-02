package com.example.jonathalima.imageviewclick;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.imageViewCores);
        imgView.setDrawingCacheEnabled(true);
        imgView.buildDrawingCache(true);

        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                    bitmap = imgView.getDrawingCache();
                    int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    Log.d(null, "RGB: " + r + g + b);

                }
                return true;
            }
        });
    }
}
