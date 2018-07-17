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

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber.PhoneNumber;

public class ActividadUno extends AppCompatActivity {
    public static String DatoEntrada = "DatoEntrada";
    EditText textoEntrada;
    String input;
    public static final int PERMISO_LLAMADA = 10;
    public static final int REQUEST_CODE_ACTIVIDAD2 = 10;

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
                startActivityForResult(actividadDos, REQUEST_CODE_ACTIVIDAD2);
                break;
            case R.id.botonLlamar:
                opcionLlamar();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISO_LLAMADA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("Actividades:Call", "Permiso Concedido");
                    opcionLlamar();
                } else {
                    Log.d("Actividades:Call", "Permiso Denegado");
                }
            }
        }
    }

    public void opcionLlamar() {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.createInstance(this);

        try {
            PhoneNumber number = phoneUtil.parse(input, "ES");
            if (phoneUtil.isValidNumber(number)) {
                String telefonoURI = "tel:" + input;
                Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse(telefonoURI));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_LLAMADA);
                else
                    startActivity(llamar);
            }
            else
                Toast.makeText(this, "El número introducido no es valido.", Toast.LENGTH_SHORT).show();
        } catch (NumberParseException e) {
            Toast.makeText(this, "Excepción: El número introducido no es valido.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_ACTIVIDAD2:

                if (resultCode == RESULT_OK) {
                    int divisores = data.getIntExtra(ActividadDos.VALOR_DEVUELTO, -1);

                    if (divisores == 2)
                        Toast.makeText(this, "Numero primo", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "Tiene " + divisores + " divisores", Toast.LENGTH_SHORT).show();
                }
            break;
        }
    }
}
