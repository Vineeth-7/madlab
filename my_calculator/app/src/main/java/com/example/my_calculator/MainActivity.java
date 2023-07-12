package com.example.my_calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void one(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"1");
    }

    public void two(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"2");
    }

    public void three(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"3");
    }

    public void four(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"4");
    }

    public void five(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"5");
    }

    public void six(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"6");
    }

    public void seven(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"7");
    }

    public void eight(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"8");
    }

    public void nine(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"9");
    }

    public void zero(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"0");
    }

    public void plus(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"+");
    }

    public void min(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"-");
    }

    public void mul(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"*");
    }

    public void divn(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+"/");
    }

    public void clear(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText("");
    }

    public void dot(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        a.setText(a.getText().toString()+".");
    }

    public void eval(View view){
        EditText a = (EditText) findViewById(R.id.expression);
        String exp=a.getText().toString();
        try {
            if (exp.contains("+")) {
                String ele[] = exp.split("\\+", 2);
                double x = Double.parseDouble(ele[0]);
                double y = Double.parseDouble(ele[1]);
                a.setText("" + (x + y));
            } else if (exp.contains("-")) {
                String ele[] = exp.split("\\-", 2);
                double x = Double.parseDouble(ele[0]);
                double y = Double.parseDouble(ele[1]);
                a.setText("" + (x - y));
            } else if (exp.contains("*")) {
                String ele[] = exp.split("\\*", 2);
                double x = Double.parseDouble(ele[0]);
                double y = Double.parseDouble(ele[1]);
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                a.setText("" + (numberFormat.format(x * y)));
            } else if (exp.contains("/")) {
                String ele[] = exp.split("\\/", 2);
                double x = Double.parseDouble(ele[0]);
                double y = Double.parseDouble(ele[1]);
                if (y != 0) {
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    a.setText("" + (numberFormat.format(x / y)));
                } else
                    Toast.makeText(this, "division by zero error", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "invalid expression", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(this, "invalid expression", Toast.LENGTH_SHORT).show();
        }
    }
}