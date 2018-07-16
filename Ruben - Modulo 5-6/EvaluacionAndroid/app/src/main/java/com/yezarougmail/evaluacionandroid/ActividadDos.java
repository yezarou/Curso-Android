package com.yezarougmail.evaluacionandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActividadDos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        Intent intent =  getIntent();

        if (intent != null){
            String valorActividadDos = intent.getStringExtra(ActividadUno.DatoEntrada);
            Toast.makeText(this, "Valor enviado: " + valorActividadDos, Toast.LENGTH_SHORT).show();
        }
    }
}
