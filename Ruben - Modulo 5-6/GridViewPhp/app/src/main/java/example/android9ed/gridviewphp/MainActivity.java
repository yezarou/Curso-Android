package example.android9ed.gridviewphp;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET},
                10);
        txt = findViewById(R.id.editText);
    }

    public void onClick (View view) {
        try {
            int numero = Integer.parseInt(txt.getText().toString());
            if (numero <= 0 || numero >= 196)
                Toast.makeText(this, "El número debe estar entre 1 y 195.", Toast.LENGTH_SHORT).show();
            else {
                Intent ventana = new Intent(this, ActividadDos.class);
                ventana.putExtra("imagen", numero);
                startActivity(ventana);
                txt.setText("");
            }
        } catch (Exception e){
            Toast.makeText(this, "Debe ser un número valido.", Toast.LENGTH_SHORT).show();
        }
    }
}
