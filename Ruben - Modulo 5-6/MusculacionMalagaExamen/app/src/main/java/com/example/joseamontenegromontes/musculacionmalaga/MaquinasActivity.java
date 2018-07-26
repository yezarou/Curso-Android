package com.example.joseamontenegromontes.musculacionmalaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MaquinasActivity extends AppCompatActivity {
    // ID
    final static String MAQUINA_SELECCIONADA = "Maquina_Actual";

    // Variables de clase
    ArrayList<Maquina> maquinas;
    ListView listaMaquinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquinas);

        listaMaquinas = (ListView) findViewById(R.id.listViewMaquinas);

        Intent intent = getIntent();
        if (intent != null){
            maquinas = (ArrayList<Maquina>) intent.getExtras().get(MainActivity.LISTA_MAQUINAS);
            MaquinasAdapter adapter = new MaquinasAdapter(this, R.layout.maquina_layout, maquinas);
            listaMaquinas.setAdapter(adapter);
        }

        listaMaquinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalleActivity = new Intent(getBaseContext(), DetalleMaquinaActivity.class);
                detalleActivity.putExtra(MAQUINA_SELECCIONADA, maquinas.get(position));
                startActivity(detalleActivity);
            }
        });
    }
}
