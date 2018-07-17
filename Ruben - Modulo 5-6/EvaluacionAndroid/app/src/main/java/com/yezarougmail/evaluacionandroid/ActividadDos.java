package com.yezarougmail.evaluacionandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActividadDos extends AppCompatActivity {

    TextView datosActividadUno, TextoDivisores;
    public static final String VALOR_DEVUELTO="ValorDevuelto";
    List<Integer> listaDivisores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        datosActividadUno = findViewById(R.id.textoDatoActividad1);
        TextoDivisores = findViewById(R.id.textoDivisores);

        listaDivisores = new ArrayList<>();

        Intent intent =  getIntent();

        if (intent != null){
            String valorActividadDos = intent.getStringExtra(ActividadUno.DatoEntrada);
            datosActividadUno.setText(valorActividadDos);
            listaDivisores = calcularDivisores(Integer.parseInt(datosActividadUno.getText().toString()));
            TextoDivisores.setText(listaDivisores.toString());
        }
    }

    private List<Integer> calcularDivisores(int numero) {
        List<Integer> divisores = new ArrayList<>();

        for (int i = 1; i <= numero/2; i++) {
            if (numero%i == 0)
                divisores.add(i);
        }
        divisores.add(numero);

        return divisores;
    }

    public void devolverInformacion(){
        Intent intent = getIntent();
        intent.putExtra(VALOR_DEVUELTO, listaDivisores.size());
        this.setResult(RESULT_OK, intent);
    }

    public void volver (View v) {
        devolverInformacion();
        finish();
    }

    @Override
    public void onBackPressed() {
        devolverInformacion();
        super.onBackPressed();
    }
}
