package com.yezarougmail.calculadorapolacainversa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import prCPI.CPI;

public class MainActivity extends AppCompatActivity {
    private CPI cpi;
    EditText et;
    TextView tv;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpi = new CPI();
        et = findViewById(R.id.editText);
        tv = findViewById(R.id.textView);

        if (savedInstanceState != null) tv.setText(savedInstanceState.getString("Resultado"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("Resultado", tv.getText().toString());
    }

        public void introducirNumero(View v){
        String numero = et.getText().toString();
        try{
            cpi.entra(Double.parseDouble(numero));
        } catch (Exception e) {
            Toast.makeText(this,"Introduce un número valido.",Toast.LENGTH_SHORT);
        }
    }

    public void sumar(View v) { cpi.suma(); }
    public void resta(View v) { cpi.resta(); }
    public void multiplica(View v) { cpi.multiplica(); }
    public void divide(View v) { cpi.divide(); }
    public void resultado(View v) {
        Double res = cpi.getResultado();
        tv.setText(res.toString());
    }
}
