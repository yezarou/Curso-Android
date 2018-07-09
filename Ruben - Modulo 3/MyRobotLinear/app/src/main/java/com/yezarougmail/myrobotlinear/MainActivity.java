package com.yezarougmail.myrobotlinear;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    RadioButton rbb;
    RadioButton rbg;
    RadioGroup rg;
    ImageView iv;
    Resources.Theme t;
    Button bt;
    EditText et;

    int colorFondo = Color.WHITE;
    int colorTexto = Color.BLACK;
    boolean imagenRedonda = false;
    Context c;

    private myL myListener;
    private class myL implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonRed:
                    Long ctl = Long.valueOf(0);
                    String sn = et.getText().toString();
                    if (sn.matches("0x[0-9a-fA-F]{8}")) {
                        try {
                            ctl = Long.parseLong(sn.substring(2), 16);
                            colorFondo = ctl.intValue();
                        } catch (Exception e) {
                            Log.i("Ruben", "Fallaso por aqui");
                            Toast.makeText(c, "hola", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        colorFondo = getResources().getColor(R.color.colorPrimary);
                        colorTexto = Color.YELLOW;
                    }
                break;
                case R.id.imageView:
                    imagenRedonda = true;
                    iv.setImageResource(R.mipmap.ic_launcher_round);
                    switch (rg.getCheckedRadioButtonId()){
                        case R.id.radioButtonBlue: colorFondo = 0xFF0000FF; colorTexto = Color.WHITE; break;
                        case R.id.radioButtonGreen: colorFondo = 0xFF00FF00; break;
                    }
                break;
            }
            tv.setBackgroundColor(colorFondo);
            tv.setTextColor(colorTexto);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("colorFondo", colorFondo);
        outState.putInt("colorTexto", colorTexto);
        outState.putBoolean("imagenRedonda", imagenRedonda);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=this.getApplicationContext();
        tv = findViewById(R.id.textView);
        rbb = findViewById(R.id.radioButtonBlue);
        rbg = findViewById(R.id.radioButtonGreen);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        iv = findViewById(R.id.imageView);
        et = findViewById(R.id.editText);
        t=this.getTheme();
        bt = findViewById(R.id.buttonRed);
        myListener = new myL();
        bt.setOnClickListener(myListener);
        iv.setOnClickListener(myListener);

        if (savedInstanceState != null){
            colorFondo = savedInstanceState.getInt("colorFondo", Color.WHITE);
            colorTexto = savedInstanceState.getInt("colorTexto", Color.BLACK);
            imagenRedonda = savedInstanceState.getBoolean("imagenRedonda");

            if (imagenRedonda)
                iv.setImageResource(R.mipmap.ic_launcher_round);

            tv.setBackgroundColor(colorFondo);
            tv.setTextColor(colorTexto);
        }
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
