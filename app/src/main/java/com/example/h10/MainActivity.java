package com.example.h10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random ran = new Random();

    int min = -999;
    int max = 999;
    int ranNumber,ranNumber2,ranNumber3;
    int num, num2, num3;
    Intent si;
    EditText a,b,c;
    TextView answer;
    double x1;

     double x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent ti = getIntent();
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (EditText) findViewById(R.id.c);
        answer = (TextView) findViewById(R.id.answer);
        a.setText("");
        b.setText("");
        c.setText("");

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        if (data_back != null) {
            x1 = data_back.getDoubleExtra("x1", 0);
            x2 = data_back.getDoubleExtra("x2", 0);
            answer.setText("x1 ="+x1+" x2 ="+x2);
            /*if (x1 != -999){
                if (x2 != -999){
                    answer.setText("x1 ="+String.valueOf(x1)+" x2 ="+String.valueOf(x2));
                }
                else {
                    answer.setText("x1 ="+String.valueOf(x1));
                }
            }*/
        }
    }
    public int getRan(){
        ranNumber= ran.nextInt((max - min) + 1) + min;
        return ranNumber;
    }
    public int getRan2(){
        ranNumber2= ran.nextInt((max - min) + 1) + min;
        return ranNumber2;
    }
    public int getRan3(){
        ranNumber= ran.nextInt((max - min) + 1) + min;
        return ranNumber3;
    }

    public void rand(View view) {
        ranNumber= ran.nextInt((max - min) + 1) + min;
        ranNumber2= ran.nextInt((max - min) + 1) + min;
        ranNumber3= ran.nextInt((max - min) + 1) + min;

        String rN = String.valueOf(ranNumber);
        String rN2 = String.valueOf(ranNumber2);
        String rN3 = String.valueOf(ranNumber3);

        a.setText(rN);
        b.setText(rN2);
        c.setText(rN3);
    }

    public void show(View view) {
        if (TextUtils.isEmpty(a.getText().toString())){
            ranNumber=getRan();
            num = ranNumber;
            String rN = String.valueOf(ranNumber);
            a.setText(rN);
        }else {
            String av = a.getText().toString();
            num= Integer.parseInt(av);

        }
        if (TextUtils.isEmpty(b.getText().toString())){
            ranNumber2=getRan2();
            num2 = ranNumber2;
            String rN = String.valueOf(ranNumber2);
            b.setText(rN);
        }else {
            String bv = b.getText().toString();
            num2 = Integer.parseInt(bv);
        }
        if (TextUtils.isEmpty(c.getText().toString())){
            ranNumber3=getRan3();
            num3 = ranNumber3;
            String rN = String.valueOf(ranNumber3);
            c.setText(rN);
        }else {
            String cv = c.getText().toString();
            num3 = Integer.parseInt(cv);
        }

        si = new Intent(this,SecondActivity.class);
        si.putExtra("num",num);
        si.putExtra("num2",num2);
        si.putExtra("num3",num3);

        startActivityForResult(si,1);
    }



}