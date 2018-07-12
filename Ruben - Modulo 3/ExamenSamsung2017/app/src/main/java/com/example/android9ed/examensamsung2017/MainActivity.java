package com.example.android9ed.examensamsung2017;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float acc = 0;
    int count = 0;
    float media = 0;

    EditText et;
    TextView res;
    Button reset;
    Button enter;
    Button average;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("Result", res.getText().toString());
        outState.putFloat("Acc", acc);
        outState.putInt("Count", count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        res = (TextView) findViewById(R.id.textViewResult);
        reset = (Button) findViewById(R.id.buttonReset);
        enter = (Button) findViewById(R.id.buttonEnter);
        average = (Button) findViewById(R.id.buttonAvg);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc = 0; count = 0;
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    acc += Float.parseFloat(et.getText().toString());
                    count++;
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Número no valido", Toast.LENGTH_SHORT);
                }
            }
            });
        average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new myAsyncTask().execute();
            }
        });

        if (savedInstanceState != null){
            res.setText(savedInstanceState.getString("Result", getResources().getString(R.string.resultString).toString()));
            acc = savedInstanceState.getFloat("Acc",0);
            count = savedInstanceState.getInt("Count",0);
        }
    }

    private class myAsyncTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            Thread hilo = new Thread(new calcularMedia());
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (count != 0)
                res.setText(getResources().getString(R.string.resultString) + " " + media);
        }
    }

    private class calcularMedia implements Runnable{
        @Override
        public void run() {
            media = mediaDesdeC(acc, count);
        }
    }

    public native float mediaDesdeC(float acc, int count);
}
