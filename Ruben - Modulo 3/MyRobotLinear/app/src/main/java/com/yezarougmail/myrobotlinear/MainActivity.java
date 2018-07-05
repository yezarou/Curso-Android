package com.yezarougmail.myrobotlinear;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
    Resources.Theme t;
    Button bt;

    private myL myListener;
    private class myL implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonRed:
                    tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    tv.setTextColor(Color.YELLOW);
                break;
                case R.id.imageView:
                    iv.setImageResource(R.mipmap.ic_launcher_round);
                    switch (rg.getCheckedRadioButtonId()){
                        case R.id.radioButtonBlue: tv.setBackgroundColor(0xFF0000FF); tv.setTextColor(Color.WHITE); break;
                        case R.id.radioButtonGreen: tv.setBackgroundColor(0xFF00FF00); break;
                    }
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        rbb = findViewById(R.id.radioButtonBlue);
        rbg = findViewById(R.id.radioButtonGreen);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        iv = findViewById(R.id.imageView);
        t=this.getTheme();
        bt = findViewById(R.id.buttonRed);
        myListener = new myL();
        bt.setOnClickListener(myListener);
        iv.setOnClickListener(myListener);

        /*
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.radioButtonBlue: tv.setBackgroundColor(0xFF0000FF); tv.setTextColor(Color.WHITE); break;
                    case R.id.radioButtonGreen: tv.setBackgroundColor(0xFF455312); tv.setTextColor(Color.CYAN); break;
                }
            }
        });
        */

        /*
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    iv.setImageResource(R.mipmap.ic_launcher_round);
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                    iv.setImageResource(R.mipmap.ic_launcher);
                return false;
            }
        });
        */

        /*
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tv.setTextColor(Color.YELLOW);
            }
        });
        */
    }


    /*
    public void botonPulsado(View v){
        //tv.setBackgroundColor(getResources().getColor(R.color.colorAccent, this.getTheme()));
        tv.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        tv.setTextColor(Color.WHITE);
    }

    public void robotPulsado(View v){
        iv.setImageResource(R.mipmap.ic_launcher_round);
        switch (rg.getCheckedRadioButtonId()){
            case R.id.radioButtonBlue: tv.setBackgroundColor(0xFF0000FF); tv.setTextColor(Color.WHITE); break;
            case R.id.radioButtonGreen: tv.setBackgroundColor(0xFF00FF00); break;
        }

        // if (rbb.isChecked()) tv.setBackgroundColor(0xFF0000FF);
        // else if (rbg.isChecked()) tv.setBackgroundColor(0xFF00FF00);
    }
    */
}
