package com.yezarougmail.evaluacionandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadUno extends AppCompatActivity {
    public static String DatoEntrada = "DatoEntrada";
    EditText textoEntrada;
    String input;
    public static final int PERMISO_LLAMADA = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        textoEntrada = findViewById(R.id.informacionEntrada);
    }

    public void onClick(View view) {
        input = textoEntrada.getText().toString();
        Log.d("ActividadUno:OnClick", "El número es: " + input);

        if (input.isEmpty())
            Toast.makeText(getApplicationContext(), R.string.AvisoEntradaVaciaToast, Toast.LENGTH_SHORT).show();
        else switch (view.getId()) {
            case R.id.botonCalcular:
                Intent actividadDos = new Intent(this, ActividadDos.class);
                actividadDos.putExtra(DatoEntrada, input);
                startActivity(actividadDos);
                break;
            case R.id.botonLlamar:
                opcionLlamar();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISO_LLAMADA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("Actividades:Call", "Permiso Concedido");
                    opcionLlamar();
                } else {
                    Log.d("Actividades:Call", "Permiso Denegado");
                }
                return;
            }
        }
    }

    public void opcionLlamar() {
        String telefonoURI = "tel:" + input;
        Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse(telefonoURI));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_LLAMADA);
        else
            startActivity(llamar);
    }
}
