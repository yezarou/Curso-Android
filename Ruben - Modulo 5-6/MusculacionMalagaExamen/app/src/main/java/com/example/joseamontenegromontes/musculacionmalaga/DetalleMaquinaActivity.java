package com.example.joseamontenegromontes.musculacionmalaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleMaquinaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_maquina);

        Intent intent = getIntent();

        if (intent != null){
            Maquina maquina = (Maquina) intent.getExtras().get(MaquinasActivity.MAQUINA_SELECCIONADA);
            ((ImageView) findViewById(R.id.imageViewmaquinaDetalle)).setImageResource(maquina.getIcono());
            ((TextView) findViewById(R.id.textViewNombre)).setText(maquina.getNombreMaquina());
            ((TextView) findViewById(R.id.textViewValorFuncion)).setText(maquina.getFuncion());
            ((TextView) findViewById(R.id.textViewValorNivel)).setText(Integer.toString(maquina.getNivel()));
            ((TextView) findViewById(R.id.textViewValorDesarrollo)).setText(maquina.getDesarrollo());
            ((TextView) findViewById(R.id.textViewPrecauciones)).setText(maquina.getPrecauciones());

        }
    }
}
