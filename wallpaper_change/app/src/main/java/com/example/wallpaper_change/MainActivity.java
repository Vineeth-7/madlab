package com.example.wallpaper_change;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    boolean running=false;
    int ia[]=new int[]{R.drawable.bg1,R.drawable.bg2,R.drawable.bg3,R.drawable.bg4,R.drawable.bg5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.wallbtn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0, 3000);
            running = true;
        }
    }


    private class MyTimer extends TimerTask{
        public void run(){
            try{
                WallpaperManager wm = WallpaperManager.getInstance(getBaseContext());
                Random r = new Random();
                wm.setBitmap(BitmapFactory.decodeResource(getResources(),ia[r.nextInt(5)]));

            }
            catch(IOException e){}
        }
    }
}
