package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonStart, buttonStop;
    TextView counterValue;

    public int counter=0;
    public boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart=(Button)findViewById(R.id.btn_start);
        buttonStart.setOnClickListener(this);
        buttonStop=(Button)findViewById(R.id.btn_stop);
        buttonStop.setOnClickListener(this);
        counterValue=(TextView)findViewById(R.id.txt_value);

    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(buttonStart)){
            counterStart();
            buttonStart.setEnabled(false);
            buttonStop.setEnabled(true);
        } else if(v.equals(buttonStop)) {
            counterStop();
            buttonStart.setEnabled(true);
            buttonStop.setEnabled(false);
        }

    }



    private void counterStop() {
        this.running=false;

    }

    private void counterStart() {
        running=true;
        new MyCounter().start();

    }

    Handler handler = new Handler(Looper.getMainLooper())
    {
        public void handleMessage(Message mes)
        {

            counterValue.setText(String.valueOf(mes.what));
        }
    };


    class MyCounter extends Thread
    {
        public void run()
        {
            while(running){
                    counter++;
                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);
                } catch(Exception e){

                }

            }
        }
    }
}