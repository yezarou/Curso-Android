package com.yezarougmail.myrobot;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    RadioButton rbb;
    RadioButton rbg;
    RadioGroup rg;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        rbb = findViewById(R.id.radioButtonBlue);
        rbg = findViewById(R.id.radioButtonGreen);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        iv = findViewById(R.id.imageView);
    }

    public void botonPulsado(View v){
        tv.setBackgroundColor(Color.RED);
        tv.setTextColor(Color.WHITE);
    }

    public void robotPulsado(View v){
        iv.setImageResource(R.mipmap.ic_launcher_round);
        switch (rg.getCheckedRadioButtonId()){
            case R.id.radioButtonBlue: tv.setBackgroundColor(0xFF0000FF); tv.setTextColor(Color.WHITE); break;
            case R.id.radioButtonGreen: tv.setBackgroundColor(0xFF00FF00); break;
        }

//        if (rbb.isChecked()) tv.setBackgroundColor(0xFF0000FF);
//        else if (rbg.isChecked()) tv.setBackgroundColor(0xFF00FF00);
    }
}
